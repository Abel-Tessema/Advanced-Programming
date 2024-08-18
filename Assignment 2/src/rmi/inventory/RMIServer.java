package rmi.inventory;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class RMIServer extends UnicastRemoteObject implements InventoryService {

    private final List<Item> items = new ArrayList<>();
    private static class Item {
        String name;
        int quantity;
        double price;

        Item(String name, int quantity, double price) {
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", Quantity: " + quantity + ", Price: $" + price;
        }
    }

    protected RMIServer() throws RemoteException {
        super();
    }

    @Override
    public void addItem(String name, int quantity, double price) throws RemoteException {
        items.add(new Item(name, quantity, price));
    }

    @Override
    public List<String> getItems() throws RemoteException {
        List<String> itemList = new ArrayList<>();
        for (Item item : items) {
            itemList.add(item.toString());
        }
        return itemList;
    }

    @Override
    public boolean deleteItem(String name) throws RemoteException {
        return items.removeIf(item -> item.name.equals(name));
    }

    public static void main(String[] args){
        try {
            Registry registry = LocateRegistry.createRegistry(12345);
            registry.rebind("InventoryService", new RMIServer());

            System.out.println("InventoryService is running.");
        } catch (Exception e) {
            System.err.println("Server exception: " + e);
            e.printStackTrace();
        }
    }
}
