import java.net.Socket;
import java.io.*;

public class EchoClient1 {

    public static void main(String[] args) throws Exception {
        String message;
        Socket clientsocket = new Socket("localhost", 1453);
        BufferedReader stdin, in;

        stdin = new BufferedReader(new InputStreamReader(System.in));
        in = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));        
        PrintWriter out = new PrintWriter(clientsocket.getOutputStream(), true);
        
        while((message = stdin.readLine()) != null){
            out.println(message);
            System.out.println("Echo : " + in.readLine());
        }            
        clientsocket.close();
    }
}
