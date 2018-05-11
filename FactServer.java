import java.io.*;
import java.net.*;
public class FactServer
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
		int number = Integer.parseInt(input);

		/* doing requires calculations */
		int result=1;
		for (int i = 1; i <= number; i++)
			result *= i;
		
		/* sending back the result to client */
		DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream());
		outToClient.writeBytes(result + "\n");
		clientSocket.close();
	}
}