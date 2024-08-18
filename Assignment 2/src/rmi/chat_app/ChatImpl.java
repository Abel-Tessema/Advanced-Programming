package rmi.chat_app;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ChatImpl extends UnicastRemoteObject implements Chat {
    private List<String> messages;

    protected ChatImpl() throws RemoteException {
        super();
        messages = new ArrayList<>();
    }

    public synchronized void sendMessage(String message) throws RemoteException {
        messages.add(message);
    }

    public synchronized String receiveMessage() throws RemoteException {
        if (messages.isEmpty()) {
            return "No new messages";
        } else {
            return messages.removeFirst();
        }
    }

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(12345);
            registry.rebind("ChatService", new ChatImpl());
            System.out.println("Chat Service is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
