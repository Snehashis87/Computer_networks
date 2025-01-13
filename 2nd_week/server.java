import java.io.*;
import java.net.*;

public class server {
    public static void main(String[] args) {
        try {
            // Step 1: Create a server socket on port 12345
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is waiting for connections...");

            // Step 2: Wait for a client to connect
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            // Step 3: Get input and output streams for communication
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

            // Step 4: Read message from the client and send the same message back
            String clientMessage;
            while ((clientMessage = input.readLine()) != null) {
                System.out.println("Received from client: " + clientMessage);
                output.println("Echo: " + clientMessage);  // Send echo message back
            }

            // Step 5: Close the connections
            input.close();
            output.close();
            clientSocket.close();
            serverSocket.close();
            System.out.println("Server closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
