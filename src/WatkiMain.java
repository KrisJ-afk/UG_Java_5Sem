import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WatkiMain {

	public static void main(String[] args) 	
	{
		//Zad 1 + 2
		Thread watek1 = ZrobNowyWatek("Pierwszy", false);
		Thread watek2 = ZrobNowyWatek("Drugi", false);
		watek1.start();
		watek2.start();
		while(watek1.isAlive() || watek2.isAlive())
		{
			// czekamy az skoncza
			// mozna by sie zabezpieczyc jakims timerem
			// zeby za dlugo nie trwalo
		}
		
		// Praktycznie to samo co wyzej ale prosciej i bezpieczniej
		ExecutorService es = Executors.newCachedThreadPool();
		for(int i=0;i<2;i++)
		    es.execute(new WatekInfo("watekInfo" + i));
		es.shutdown();
		try 
		{
			boolean finished = es.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Zad 3
		Thread watek1zmianaNazwy = ZrobNowyWatek("watek1zmianaNazwy", true);
		Thread watek2zmianaNazwy = ZrobNowyWatek("watek2zmianaNazwy", true);
		watek1zmianaNazwy.start();
		watek2zmianaNazwy.start();
		
	}

	private static Thread ZrobNowyWatek(String userName, Boolean setThreadName)
	{
		Thread w = new Thread(new WatekInfo(userName));
		if(setThreadName)
			w.setName(userName+ "_" + java.util.UUID.randomUUID());
		return w;
	}

}
