import java.io.*;
import java.net.*;

public class FactClient
{
	public static void main(String args[]) throws IOException,ClassNotFoundException
	{
		/* creating client socket */
		Socket clientSocket = new Socket("localhost", 1313);

		/* reading user input */
		System.out.println("Enter the number: ");		
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));		
		String input = stdin.readLine();

		/* sending input to server */
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		outToServer.writeBytes(input + '\n');

		/* getting back result from server */
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		String result = inFromServer.readLine();
		System.out.println(input + "! = " + result);
	}
}