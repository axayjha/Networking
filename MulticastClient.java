/*
	16/03/2018
	AKshay
*/
import java.util.Date;
import java.io.*;
import java.net.*;

public class MulticastClient {
	public static void main(String[] args) throws IOException {
		MulticastSocket socket = new MulticastSocket(1315);
		InetAddress group = InetAddress.getByName("230.0.0.3");
		socket.joinGroup(group);

		byte[]buf = new byte[256];
		DatagramPacket packet = new DatagramPacket(buf, buf.length);
		socket.receive(packet);
		System.out.println("Current server time: " + new String(packet.getData()));

		socket.leaveGroup(group);
		socket.close();
	}
}