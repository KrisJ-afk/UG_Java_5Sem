import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class IpPokazywacz 
{
	public static void main(String[] args) throws SocketException 
	{
        Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
        Dictionary dict = new Hashtable(); 

    	System.out.println("Dostenpne interfejsy: ");
    	int idx = 0;
        for (NetworkInterface netint : Collections.list(nets))
        {
        	String name = netint.getName();
        	System.out.println(idx + " : " + name);
        	dict.put(idx, netint); 
        	idx++;
        }

    	System.out.println("Podaj nr interfejsu: ");
        Scanner userInput = new Scanner(System.in);
        String stringNumber = userInput.nextLine();
        if(!tryParseInt(stringNumber))
        	return;
        
        int intIdx = Integer.parseInt(stringNumber);
        if(intIdx > idx)
        	return;
        DisplayInfo((NetworkInterface)dict.get(intIdx));
    }
	
	private static void DisplayInfo(NetworkInterface netint) throws SocketException 
	{
        System.out.printf("Display name: %s\n", netint.getDisplayName());
        System.out.printf("Name: %s\n", netint.getName());
        Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
        for (InetAddress inetAddress : Collections.list(inetAddresses)) {
        	 System.out.printf("InetAddress: %s\n", inetAddress);
        }
        System.out.printf("\n");
     }
	
	private static boolean tryParseInt(String value) {  
	     try {  
	         Integer.parseInt(value);  
	         return true;  
	      } catch (NumberFormatException e) {  
	         return false;  
	      }  
	}
}