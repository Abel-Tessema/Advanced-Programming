package rmi.calculator_service;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            String host = "192.168.0.107";
            int port = 12345;
            Registry registry = LocateRegistry.getRegistry(host, port);

            Calculator calculator = (Calculator) registry.lookup("CalculatorService");

            System.out.println("Add: " + calculator.add(5, 3));
            System.out.println("Subtract: " + calculator.subtract(5, 3));
            System.out.println("Multiply: " + calculator.multiply(5, 3));
            System.out.println("Divide: " + calculator.divide(5, 3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

