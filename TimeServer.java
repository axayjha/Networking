import java.io.*;
import java.net.*;
import java.util.Date;

public class TimeServer{
	public static void main(String args[]) throws IOException{
		ServerSocket servsock = null;
		try{
			servsock = new ServerSocket(1313);
		} catch (IOException e) {
			System.out.println("Couldn't connect");
			System.exit(1);
		}

		Socket clientsock = null;
		while(true) {
			try{
				clientsock = servsock.accept();
			} catch (IOException e) {
				System.out.println("Server didn't accept");
				System.exit(1);
			}

			ObjectOutputStream opstream = null;
			opstream = new ObjectOutputStream(clientsock.getOutputStream());
			opstream.writeObject(new Date());
			opstream.close();
			clientsock.close();
		}

	}
}