 import java.net.*;
import java.io.*;

 class StringServer{
 	public static void main(String[] args) throws Exception{
 		String clientSentence;
 		String captitalizedSentence;
 		ServerSocket welcomeSocket = new ServerSocket(2345);
 		while(true){
 			Socket connectionSocket = welcomeSocket.accept();
 			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
 			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
 			clientSentence = inFromClient.readLine();
 			captitalizedSentence = clientSentence.toUpperCase() + '\n';
 			outToClient.writeBytes(captitalizedSentence);
 		}
 	}
 }