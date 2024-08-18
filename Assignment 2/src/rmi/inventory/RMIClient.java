package rmi.inventory;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class RMIClient {
    public static void main(String[] args) {
        try {
            String host = "192.168.0.107";
            int port = 12345;
            Registry registry = LocateRegistry.getRegistry(host, port);

            InventoryService inventory = (InventoryService) registry.lookup("InventoryService");

            // Add items
            inventory.addItem("Laptop", 10, 999.99);
            inventory.addItem("Smartphone", 20, 499.99);

            // Retrieve items
            List<String> items = inventory.getItems();
            System.out.println("Items in inventory:");
            for (String item : items) {
                System.out.println(item);
            }

            // Delete an item
            boolean deleted = inventory.deleteItem("Laptop");
            System.out.println("Laptop deleted: " + deleted);

            // Retrieve items again
            items = inventory.getItems();
            System.out.println("Items in inventory after deletion:");
            for (String item : items) {
                System.out.println(item);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

