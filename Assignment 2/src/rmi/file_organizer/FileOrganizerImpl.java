package rmi.file_organizer;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class FileOrganizerImpl extends UnicastRemoteObject implements FileOrganizer {

    protected FileOrganizerImpl() throws RemoteException {
        super();
    }

    @Override
    public void organizeFilesByExtension(String directoryPath) throws RemoteException {
        File directory = new File(directoryPath);
        if (!directory.isDirectory()) {
            System.out.println("The provided path is not a directory.");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("Unable to list files in the directory.");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                String extension = getFileExtension(file);
                if (extension != null) {
                    File extensionDir = new File(directoryPath + File.separator + extension);
                    if (!extensionDir.exists()) {
                        extensionDir.mkdir();
                    }
                    file.renameTo(new File(extensionDir + File.separator + file.getName()));
                }
            }
        }
        System.out.println("Files have been organized by extension.");
    }

    private String getFileExtension(File file) {
        String fileName = file.getName();
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
            return fileName.substring(dotIndex + 1).toLowerCase();
        }
        return null;
    }
}
