import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class stopServer {
    public static void main(String[] args) throws IOException {
        createServer a = new createServer();
        int port = a.port;
        boolean serverstatus = a.running;
        ServerSocket serverSocket = a.serverSocket;
        Socket clientSockets = a.clientSocket;


    }
}
