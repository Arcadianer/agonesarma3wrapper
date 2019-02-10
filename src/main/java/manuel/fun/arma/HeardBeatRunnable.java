package manuel.fun.arma;

import java.util.logging.Level;

import io.swagger.client.ApiException;
import io.swagger.client.api.SdkApi;
import io.swagger.client.model.SdkEmpty;
import lombok.extern.java.Log;

@Log
public class HeardBeatRunnable implements Runnable {

	boolean heart = false;
	long sleep = 5000;

	public HeardBeatRunnable(long sleeptime) {

		this.sleep = sleeptime;
	}

	@Override
	public void run() {
		heart = true;
		boolean fun = false;
		log.info("Heart started beating ...");
		while (heart) {
			try {
				Core.api.health(new SdkEmpty());
				if (!fun) {
					log.fine("heart...");
					fun = true;
				} else {
					log.fine("beat...");
					fun = false;
				}
				Thread.sleep(sleep);
			} catch (ApiException e1) {
				// TODO Auto-generated catch block
				log.log(Level.SEVERE, "Some shit happend with the Agones-apiserver");
				e1.printStackTrace();
			} catch (InterruptedException e) {
				log.warning("Heartbeat thread interrupted");
			}

		}
		log.info("Heart stopped beating...");

	}

	public void stop() {
		heart = false;
		log.info("Stopping Heartbeat...");
	}
}
