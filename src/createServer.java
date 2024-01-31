import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class createServer {
    public static void main(String[] args) throws IOException{
        int port = 9000;
        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("Server started on port: "+port);
        boolean running = true;

        while (running){
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connection from: "+clientSocket.getRemoteSocketAddress());

            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                String receivedText;
                while ((receivedText = in.readLine()) != null) {
                    System.out.println("Received: " + receivedText);
                    out.println("Server received your message");
                }
            } finally {
                clientSocket.close();
            }
        }
    }
}
