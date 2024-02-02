import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.io.*;

public class createClient {
    public static void main(String[] args) throws IOException {
        String serverIP = "127.0.0.1";
        int serverPort = 9000;
        InetAddress address = InetAddress.getByName(serverIP);
        Socket socket = new Socket(address, serverPort);

        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {
                System.out.println("Enter some text to send to the server:");
                String userInput = stdIn.readLine();
                if (userInput == null) {
                    break;
                }
                out.println(userInput);

                String response = in.readLine();
                System.out.println("Server: " + response);
            }
        } finally {
            socket.close();
        }
    }
}
