import java.io.*;
import java.net.*;
import java.util.Date;

public class TimeClient1{
	public static void main(String args[]) throws IOException{
		Socket clientsocket = null;

		try{
			clientsocket = new Socket("localhost", 1313);
			BufferedReader br = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
			System.out.println(br.readLine());
			clientsocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}