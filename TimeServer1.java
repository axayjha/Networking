import java.io.*;
import java.net.*;
import java.util.Date;

public class TimeServer1{
	public static void main(String args[]) throws IOException {
		ServerSocket serversocket = null;
		try{
			serversocket = new ServerSocket(1313);
			Socket cliensocket = serversocket.accept();
			DataOutputStream dos = new DataOutputStream(cliensocket.getOutputStream());
			dos.writeBytes("Date/Time of the server: " +  new Date().toString() + " \n");
			cliensocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}