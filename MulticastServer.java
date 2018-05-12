/*
	16/03/2018
	AKshay
*/
import java.util.Date;
import java.io.*;
import java.net.*;
public class MulticastServer {
	public static void main(String[] args) throws IOException, InterruptedException{
		DatagramSocket socket = new DatagramSocket(5005);
		byte[] buf;
		while(true){
			buf = new Date().toString().getBytes();
			InetAddress group = InetAddress.getByName("230.0.0.3");
			DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 1315);
			socket.send(packet);
		}
	}
}