package rmi.prime_checker;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class PrimeCheckerClient {
    public static void main(String[] args) {
        try {
            String[] workerAddresses = {
                    "rmi://localhost:1099/PrimeChecker",
                    "rmi://localhost:1100/PrimeChecker",
                    "rmi://localhost:1101/PrimeChecker",
                    "rmi://localhost:1102/PrimeChecker"
            };

            String host = "192.168.0.107";
            int port = 12345;
            Registry registry = LocateRegistry.getRegistry(host, port);

            List<PrimeChecker> workers = new ArrayList<>();
            for (String address : workerAddresses) {
                workers.add((PrimeChecker) registry.lookup(address));
            }

            int start = 1;
            int end = 100;
            int numWorkers = workers.size();

            int rangePerWorker = (end - start + 1) / numWorkers;

            List<Integer> allPrimes = new ArrayList<>();
            List<Thread> threads = new ArrayList<>();
            for (int i = 0; i < numWorkers; i++) {
                int workerStart = start + i * rangePerWorker;
                int workerEnd = (i == numWorkers - 1) ? end : workerStart + rangePerWorker - 1;
                PrimeChecker worker = workers.get(i);

                Thread thread = new Thread(() -> {
                    try {
                        List<Integer> primes = worker.findPrimes(workerStart, workerEnd);
                        synchronized (allPrimes) {
                            allPrimes.addAll(primes);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                threads.add(thread);
                thread.start();
            }

            for (Thread thread : threads) {
                thread.join();
            }

            System.out.println("Prime numbers: " + allPrimes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
