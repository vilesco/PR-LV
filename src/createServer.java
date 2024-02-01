import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class createServer {
    public int port;
    public boolean running;
    public ServerSocket serverSocket;
    public Socket clientSocket;

    public static void main() throws IOException{
        int port = 9000;
        ServerSocket serverSocket = new ServerSocket(port, 5, InetAddress.getByName("127.0.0.1"));

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
                running = false;
            }
        }
    }
}
