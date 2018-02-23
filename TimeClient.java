import java.io.*;
import java.net.*;
import java.util.Date;

public class TimeClient{
	public static void main(String []args) throws IOException{
		Socket timesocket = null;
		ObjectInputStream time = null;
		try{
			timesocket = new Socket("localhost", 1313);
			time = new ObjectInputStream(timesocket.getInputStream());
		} catch (UnknownHostException e) {
			System.out.println("Unknow host exception");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Connection Error");
			System.exit(1);
		}

		try {
			Date serverdate = (Date)time.readObject();
			System.out.println("Current Server time: " + serverdate);
		} catch ( ClassNotFoundException e ) {
			System.out.println("Not a date object returned");
			System.exit(1);
		}
		time.close();
		timesocket.close();
	}
}