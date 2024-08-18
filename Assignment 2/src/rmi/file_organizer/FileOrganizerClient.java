package rmi.file_organizer;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class FileOrganizerClient {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the path of the directory to organize: ");
            String directoryPath = scanner.nextLine();

            String host = "192.168.0.107";
            int port = 12345;
            Registry registry = LocateRegistry.getRegistry(host, port);

            FileOrganizer organizer = (FileOrganizer) registry.lookup("FileOrganizer");
            organizer.organizeFilesByExtension(directoryPath);
        } catch (Exception e) {
            System.err.println("FileOrganizerClient exception: " + e);
            e.printStackTrace();
        }
    }
}
