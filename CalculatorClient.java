import java.io.*;
import java.net.*;
public class CalculatorClient{
	public static void main(String args[])throws Exception{
		Socket s = new Socket("localhost",1500);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		BufferedReader br2 = new BufferedReader(new InputStreamReader(s.getInputStream()));

		System.out.println("Enter first number :: ");
		double d1 = Double.parseDouble(br.readLine());

		System.out.println("Enter second number :: ");
		double d2 = Double.parseDouble(br.readLine());

		System.out.println("Enter the Binary operator (+,-,/,*,%) :: ");
		char ch = br.readLine().charAt(0);

		dos.writeBytes(""+d1+"\n");
		dos.writeBytes(""+d2+"\n");
		dos.writeBytes(""+ch+"\n");

		System.out.println("Result = "+br2.readLine());
		dos.close();
		s.close();
		

	}
}