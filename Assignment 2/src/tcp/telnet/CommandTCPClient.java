package tcp.telnet;

import java.io.*;
import java.net.*;

public class CommandTCPClient {
    public static void main(String[] args) {
        String hostname = "localhost"; // Server hostname
        int port = 12345; // Port number to connect to

        try (
                Socket socket = new Socket(hostname, port);
                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String command;
            System.out.println("Enter commands (type 'exit' to quit):");

            while (true) {
                System.out.print("> ");
                command = consoleReader.readLine();

                if (command.equalsIgnoreCase("exit")) {
                    writer.println(command);
                    break;
                }

                writer.println(command);
                String response;
                while ((response = reader.readLine()) != null && !response.isEmpty()) {
                    System.out.println(response);
                }
            }

        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}
