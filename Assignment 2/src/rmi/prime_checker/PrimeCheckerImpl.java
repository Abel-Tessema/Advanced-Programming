package rmi.prime_checker;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class PrimeCheckerImpl extends UnicastRemoteObject implements PrimeChecker {
    private final String serverName;

    protected PrimeCheckerImpl(String serverName) throws RemoteException {
        super();
        this.serverName = serverName;
    }

    @Override
    public List<Integer> findPrimes(int start, int end) throws RemoteException {
        System.out.println("Server " + serverName + " is processing range: " + start + " to " + end);
        List<Integer> primes = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
