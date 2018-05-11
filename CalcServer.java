import java.io.*;
import java.net.*;
public class CalcServer
{
	public static void main(String args[]) throws IOException
	{
		ServerSocket servsoc = new ServerSocket(1313);
		Socket clientSocket = servsoc.accept();

		BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));		
		String numbers=inFromClient.readLine();

		
		numbers = numbers + " ";
		String arr[]= numbers.split(" ");
		System.out.println(arr[0] + arr[1] + arr[2]);

		int ans = 0, n1 = Integer.parseInt(arr[0]), n2 = Integer.parseInt(arr[1]);
		if(arr[2].equals("+"))	
			ans = n1 + n2;
		
		else if(arr[2].equals("-"))		
			ans = n1 - n2;
		
		else if(arr[2].equals("*"))		
			ans = n1 * n2;
		
		else		
			ans = n1 / n2;		
		
		DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream());
		outToClient.writeBytes(Integer.toString(ans) + "\n");
		clientSocket.close();
	}
}