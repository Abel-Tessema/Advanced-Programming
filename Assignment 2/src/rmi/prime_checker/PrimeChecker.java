package rmi.prime_checker;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface PrimeChecker extends Remote {
    List<Integer> findPrimes(int start, int end) throws RemoteException;
}
