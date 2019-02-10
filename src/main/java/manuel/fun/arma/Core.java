package manuel.fun.arma;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;

import com.google.common.base.Splitter.MapSplitter;
import com.ibasco.agql.protocols.valve.source.query.client.SourceQueryClient;
import com.ibasco.agql.protocols.valve.source.query.pojos.SourcePlayer;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.SdkApi;
import io.swagger.client.model.SdkEmpty;
import io.swagger.client.model.SdkKeyValue;
import lombok.Setter;
import lombok.extern.java.Log;

@Log
@Setter
public class Core {

	public static SdkApi api;
	public static Core core;
	boolean userquery = true;

	public static void main(String[] args) throws InterruptedException {
		log.info("Core init...");
		boolean start = false;
		while (!start) {
			try {
				Socket test = new Socket("127.0.0.1", 59358);
				start = true;
				test.close();
			} catch (Exception e) {
				log.info("Waiting for Agones Server ...");
			}
			
			Thread.sleep(1000);
		}
		final ApiClient swagger = new ApiClient();
		swagger.setBasePath("http://localhost:59358");
		core = new Core(swagger);
		if (args.length < 1) {
			throw new IllegalArgumentException("No logfile specified");
		}
		log.info("Starting heartbeat for init phase");
		core.startHeart();
		log.info("Locating Logfile...");
		File logfile = null;
		for (int loop = 0; loop < 5; loop++) {
			logfile = new File(args[0]);
			if (logfile.exists()) {
				log.info("Logfile found");
				break;
			} else {
				log.warning("No log found ... waiting 5 seconds");
				Thread.sleep(5000);
			}
		}
		if (!(logfile == null)) {
			log.info("Main handing over to core...");
			log.entering("Core", "run()");
			core.setLogfile(logfile);
			core.run();
			log.exiting("Core", "run()");
			log.info("Core handing over to main");
		} else {
			log.severe("NO LOGFILE FOUND");
		}

		try {
			log.info("Shutting down");
			core.stopHeart();
			Core.api.shutdown(new SdkEmpty());
		} catch (final ApiException e) {
		}
		log.info("Exiting main thread");
	}

	private ApiClient swaggerclient;
	private Thread heardbeatthread;
	private HeardBeatRunnable beatRunnable;
	private File logfile;
	private boolean shutdown = false;
	int logidleTimeout = 500;
	int logidleWarning = 400;
	int logplayingTimeout = 7200;
	int logplayingWarning = 7100;
	int playeridleTimeout = 300;
	int playeridleWarning = 240;
	final private SdkKeyValue gamestatelable = new SdkKeyValue();
	final private SdkKeyValue timeout = new SdkKeyValue();
	final private Gamestate gamestate = new Gamestate();
	InetSocketAddress steamServerQuerry = null;

	public Core(ApiClient swagger) {
		this.swaggerclient = swagger;
		Core.api = new SdkApi(swagger);
		gamestatelable.setKey("gamestate");
		timeout.setKey("timeout");
		timeout.setValue("good");
	}

	public void run() {
		log.info("Setting gamestate to booting");
		gamestatelable.setValue("booting");

		try {
			api.setLabel(gamestatelable);
		} catch (ApiException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		log.fine("Using data from logs");

		BufferedReader br;
		SourceQueryClient client = new SourceQueryClient();
		try {
			br = new BufferedReader(new FileReader(logfile));
			String line = null;
			while (!shutdown) {

				line = br.readLine();
				if (!(line == null)) {
					parse(line);
					gamestate.logidletime.set(0);
				} else
					gamestate.logidletime.incrementAndGet();
				if (userquery) {
					if (steamServerQuerry == null) {
						steamServerQuerry = new InetSocketAddress("127.0.0.1", 2303);
					}
					CompletableFuture<List<SourcePlayer>> playersFuture = client.getPlayers(steamServerQuerry);
					playersFuture.whenComplete((players, error) -> {
						gamestate.players.set(players.size());
					});
					if (gamestate.players.get() == 0) {
						gamestate.playeridletime.incrementAndGet();
					} else {
						gamestate.playeridletime.set(0);
					}
				}
				analyseGamestate();
				Thread.sleep(1000);
			}
		} catch (final FileNotFoundException e) {
			// TODO: handle exception
		} catch (final IOException e) {
			// TODO Auto-generated catch block

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void analyseGamestate() {
		try {
			switch (gamestate.status) {
			case booting:
				logtimeoutcheck();
				break;
			case idle:
				// Ready Check
				if (gamestate.players.get() == 0 && gamestate.playeridletime.get() == 0) {
					log.info("Server Ready");
					gamestatelable.setValue("idle");
					api.setLabel(gamestatelable);
					api.ready(new SdkEmpty());
					userquery = true;
				}
				playertimeoutcheck();
				logplayingoutcheck();
				break;
			case playing:
				// Just started playing check
				if (gamestate.playeridletime.get() != 0) {
					log.info("Game Session started");
					gamestatelable.setValue("playing");
					api.setLabel(gamestatelable);
				}
				// Server Empty Check
				if (gamestate.players.get() == 0) {
					log.info("Server Idle");
					gamestatelable.setValue("idle");
					api.setLabel(gamestatelable);
					gamestate.status = GameStatus.idle;
				}
				playertimeoutcheck();
				//logplayingoutcheck();
				break;
			default:
				break;
			}
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void shutdown() {
		shutdown = true;
		gamestate.status = GameStatus.shutdown;
		gamestatelable.setValue("shutdown");
	}

	private void parse(String line) {
		String[] data = line.split(" ");
		StringBuilder message = new StringBuilder();
		for (int i = 1; i < data.length; i++) {
			if (!(i == data.length - 1)) {
				message.append(data[i] + " ");
			} else {
				message.append(data[i]);
			}
		}
		log.info(message.toString());
		switch (message.toString()) {
		case "Host identity created.":
			gamestate.status = GameStatus.idle;
			break;

		default:
			break;
		}
	}

	private void startHeart() {
		this.beatRunnable = new HeardBeatRunnable(5000);
		this.heardbeatthread = new Thread(beatRunnable, "Heartbeat");
		heardbeatthread.start();
	}

	private void stopHeart() {
		beatRunnable.stop();

	}

	private void logtimeoutcheck() throws ApiException {
		if (gamestate.logidletime.get() == logidleWarning) {
			log.warning("Log Timout approaching");
			timeout.setValue("LOG TIMEOUT WARNING");
			api.setLabel(timeout);

		} else if (gamestate.logidletime.get() >= logidleTimeout) {
			log.severe("Log Timeout reached -> shutting down server");
			timeout.setValue("LOG TIMEOUT");
			api.setLabel(timeout);
			shutdown();
		} else if (gamestate.logidletime.get() == 0 && timeout.getValue().equals("LOG TIMEOUT WARNING")) {
			timeout.setValue("good");
			api.setLabel(timeout);
		}
	}
	private void logplayingoutcheck() throws ApiException {
		if (gamestate.logidletime.get() == logplayingWarning) {
			log.warning("Log Timout approaching");
			timeout.setValue("LOG TIMEOUT WARNING");
			api.setLabel(timeout);

		} else if (gamestate.logidletime.get() >= logplayingTimeout) {
			log.severe("Log Timeout reached -> shutting down server");
			timeout.setValue("LOG TIMEOUT");
			api.setLabel(timeout);
			shutdown();
		} else if (gamestate.logidletime.get() == 0 && timeout.getValue().equals("LOG TIMEOUT WARNING")) {
			timeout.setValue("good");
			api.setLabel(timeout);
		}
	}

	private void playertimeoutcheck() throws ApiException {
		if (gamestate.playeridletime.get() == playeridleWarning) {
			log.warning("Player Timout approaching");
			timeout.setValue("PLAYER TIMEOUT WARNING");
			api.setLabel(timeout);

		} else if (gamestate.playeridletime.get() >= playeridleTimeout) {
			log.severe("Player Timeout reached -> shutting down server");
			timeout.setValue("PLAYER TIMEOUT");
			api.setLabel(timeout);
			shutdown();
		} else if (gamestate.playeridletime.get() != 0 && timeout.getValue().equals("PLAYER TIMEOUT WARNING")) {
			timeout.setValue("good");
			api.setLabel(timeout);
		}
	}

}
