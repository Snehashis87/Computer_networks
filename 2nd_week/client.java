import java.io.*;
import java.net.*;

public class client {
    public static void main(String[] args) {
        try {
            // Step 1: Connect to the server at localhost on port 12345
            Socket socket = new Socket("192.168.0.107", 12345);
            System.out.println("Connected to server!");

            // Step 2: Set up input and output streams to communicate with the server
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Step 3: Send a message to the server
            System.out.print("Enter a message for the server: ");
            String message = userInput.readLine();
            output.println(message);  // Send message to the server

            // Step 4: Read the echo message from the server
            String serverResponse = input.readLine();
            System.out.println("Server says: " + serverResponse);

            // Step 5: Close the streams and socket
            userInput.close();
            output.close();
            input.close();
            socket.close();
            System.out.println("Connection closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
