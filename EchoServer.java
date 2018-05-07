import java.net.Socket;
import java.net.ServerSocket;
import java.io.*;

public class EchoServer {

    public static void main(String[] args) throws Exception {

        String message;
        ServerSocket serverSocket = new ServerSocket(1453);

        while (true) {
            Socket clientsocket = serverSocket.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientsocket.getOutputStream(), true);
            
            while((message= br.readLine() )!=null){         
           
                System.out.println("Received: " + message);
                out.println(message);
            }      
            clientsocket.close();
        }
    }
}
