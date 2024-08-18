package rmi.prime_checker;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class PrimeCheckerServer {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java PrimeCheckerServer <server-name> <port>");
            System.exit(1);
        }
        String serverName = args[0];
        int port = Integer.parseInt(args[1]);
        try {
            PrimeChecker checker = new PrimeCheckerImpl(serverName);
            Registry registry = LocateRegistry.createRegistry(port);
            registry.rebind("rmi://192.168.0.107:" + port + "/PrimeChecker", checker);
            System.out.println("PrimeChecker Server " + serverName + " is ready on port " + port + ".");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
