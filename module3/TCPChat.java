import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPChat {
    public static void main(String[] args) throws Exception {
        if (args.length > 0 && "server".equalsIgnoreCase(args[0])) {
            startServer();
        } else {
            String host = args.length > 0 ? args[0] : "localhost";
            int port = args.length > 1 ? Integer.parseInt(args[1]) : 5000;
            startClient(host, port);
        }
    }

    private static void startServer() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Server started on port 5000");
            try (Socket socket = serverSocket.accept();
                 BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {

                System.out.println("Client connected.");
                String line;
                while ((line = input.readLine()) != null) {
                    System.out.println("Client: " + line);
                    System.out.print("You: ");
                    line = console.readLine();
                    output.println(line);
                }
            }
        }
    }

    private static void startClient(String host, int port) throws IOException {
        try (Socket socket = new Socket(host, port);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connected to server.");
            while (true) {
                System.out.print("You: ");
                String message = console.readLine();
                output.println(message);
                String reply = input.readLine();
                if (reply == null) {
                    break;
                }
                System.out.println("Server: " + reply);
            }
        }
    }
}