import java.io.*;
import java.net.*;
public class CalcServer
{
	public static void main(String args[]) throws IOException
	{
		/* creating sockets */
		ServerSocket servsoc = new ServerSocket(1313);
		Socket clientSocket = servsoc.accept();

		/* getting input from client */
		BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));		
		String input = inFromClient.readLine();

		/* parsing input string */
		input = input + " ";
		String arr[]= input.split(" ");
		System.out.println(arr[0] + arr[1] + arr[2]);
		double result = 0, n1 = Double.parseDouble(arr[0]), n2 = Double.parseDouble(arr[1]);

		/* doing requires calculations */
		if(arr[2].equals("+"))	
			result = n1 + n2;
		
		else if(arr[2].equals("-"))		
			result = n1 - n2;
		
		else if(arr[2].equals("*"))		
			result = n1 * n2;
		
		else		
			result = n1 / n2;		
		
		/* sending back the result to client */
		DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream());
		outToClient.writeBytes(Double.toString(result) + "\n");
		clientSocket.close();
	}
}