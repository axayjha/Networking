import java.util.Date;
import java.io.*;
import java.net.*;
public class MulticastServer{
	public static void main(String[] args) throws IOException, InterruptedException {
		DatagramSocket socket= new DatagramSocket(5005);
		for(int i=0; i<10; i++) {
			byte[] buf = new Date().toString().getBytes();
			InetAddress group = InetAddress.getByName("230.0.0.3");
			DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 1315);
			socket.send(packet);
			Thread.sleep(2000);
		} 
		socket.close();
	}
}