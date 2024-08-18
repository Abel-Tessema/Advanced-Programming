package rmi.inventory;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface InventoryService extends Remote {
    void addItem(String name, int quantity, double price) throws RemoteException;
    List<String> getItems() throws RemoteException;
    boolean deleteItem(String name) throws RemoteException;
}
