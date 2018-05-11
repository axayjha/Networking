import java.io.*;
import java.net.*;
public class CalculatorServer{
	public static void main(String args[])throws Exception{
		ServerSocket server = new ServerSocket(1500);

		while(true){
			Socket s = server.accept();
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());

			double d1 = Double.parseDouble(br.readLine());
			double d2 = Double.parseDouble(br.readLine());
			char op = br.readLine().charAt(0);
			double res=0;
			switch(op){
				case '+':
					res = d1+d2;
					break;
				case '-':
					res = d1-d2;
					break;
				case '*':
					res = d1*d2;
					break;
				case '/':
					res = d1/d2;
					break;
				case '%':
					res = d1%d2;
					break;

			}
			dos.writeBytes(""+res+"\n");
			dos.close();
			s.close();
		}
	}
}