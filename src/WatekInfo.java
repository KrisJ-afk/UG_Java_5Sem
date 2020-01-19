import java.util.Random;

public class WatekInfo implements Runnable
{

	private Random _rnd;
	private String _userName;

	public WatekInfo(String userName)
	{
		_userName = userName;
		_rnd = new Random();
	}
	
	@Override
	public void run() 
	{
		for(int i = 0; i < 5; i++)
		{
			try
			{
				Thread.sleep(_rnd.nextInt(2500) + 500);
			}
			catch(InterruptedException e)
			{
				// ignore
			}
			System.out.println("Watek: "+ Thread.currentThread().getName() + " o nawie uzytkownika: " + _userName + " wykonal: " + i + " okrazen, co za diabel.");
		}
	}
		

}