package rmi.to_do;

import java.util.List;
import java.util.Scanner;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            String host = "192.168.0.107";
            int port = 11298;
            Registry registry = LocateRegistry.getRegistry(host, port);

            TodoList todoList = (TodoList) registry.lookup("TodoListService");

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("1. Add Task");
                System.out.println("2. Remove Task");
                System.out.println("3. List Tasks");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // consume the newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter task to add: ");
                        String taskToAdd = scanner.nextLine();
                        todoList.addTask(taskToAdd);
                        System.out.println("Task added.");
                        break;
                    case 2:
                        System.out.print("Enter task to remove: ");
                        String taskToRemove = scanner.nextLine();
                        todoList.removeTask(taskToRemove);
                        System.out.println("Task removed.");
                        break;
                    case 3:
                        List<String> tasks = todoList.getTasks();
                        System.out.println("Tasks:");
                        for (String task : tasks) {
                            System.out.println("- " + task);
                        }
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
