package rmi.to_do;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(11298);

            TodoListImpl todoList = new TodoListImpl();

            registry.rebind("TodoListService", todoList);

            System.out.println("Todo List Service is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
