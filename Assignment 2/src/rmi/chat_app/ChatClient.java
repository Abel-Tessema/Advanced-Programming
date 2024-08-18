package rmi.chat_app;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        try {
            String host = "192.168.0.107";
            int port = 12345;
            Registry registry = LocateRegistry.getRegistry(host, port);

            Chat chat = (Chat) registry.lookup("ChatService");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your message: ");
            String message = scanner.nextLine();
            chat.sendMessage(message);
            System.out.println("Message sent: " + message);
            System.out.println("Receiving messages...");
            System.out.println("Received message: " + chat.receiveMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
