package rmi.file_organizer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FileOrganizer extends Remote {
    void organizeFilesByExtension(String directoryPath) throws RemoteException;
}
