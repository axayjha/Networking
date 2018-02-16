import java.net.*;
class IPAddressTest {
	public static void main(String []args) throws UnknownHostException{
		InetAddress test  = InetAddress.getLocalHost();
		System.out.println("IP address of the machine is: " + test);
		InetAddress test1 = InetAddress.getByName("yahoo.com");
		System.out.println("IP address of yahoo.com is " + test1);
	}
}