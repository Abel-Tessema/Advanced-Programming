package rmi.file_organizer;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class FileOrganizerServer {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(12345);
            FileOrganizerImpl organizer = new FileOrganizerImpl();
            registry.rebind("FileOrganizer", organizer);
            System.out.println("FileOrganizer Server is ready.");
        } catch (Exception e) {
            System.err.println("FileOrganizer Server exception: " + e);
            e.printStackTrace();
        }
    }
}
