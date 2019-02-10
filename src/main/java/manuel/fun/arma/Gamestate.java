package manuel.fun.arma;

import java.util.concurrent.atomic.AtomicInteger;

import io.swagger.client.model.SdkKeyValue;

public class Gamestate {
public final AtomicInteger players=new AtomicInteger(0);
public final AtomicInteger logidletime=new AtomicInteger(0);
public final AtomicInteger playeridletime=new AtomicInteger(0);
public GameStatus status=GameStatus.booting;
}
enum GameStatus{
booting,idle,playing,shutdown	
}
