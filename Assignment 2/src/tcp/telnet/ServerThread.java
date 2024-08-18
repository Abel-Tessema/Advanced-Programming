package tcp.telnet;

import java.io.*;
import java.net.Socket;

class ServerThread extends Thread {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true)
        ) {
            String command;

            while ((command = reader.readLine()) != null) {
                if (command.equalsIgnoreCase("exit")) {
                    break;
                }

                String response = executeCommand(command);
                writer.println(response);
            }

            socket.close();
        } catch (IOException ex) {
            System.out.println("Server thread exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private String executeCommand(String command) {
        StringBuilder output = new StringBuilder();

        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            String s;
            while ((s = stdInput.readLine()) != null) {
                output.append(s).append("\n");
            }
            while ((s = stdError.readLine()) != null) {
                output.append(s).append("\n");
            }
        } catch (IOException e) {
            output.append("Exception: ").append(e.getMessage());
        }

        return output.toString();
    }
}