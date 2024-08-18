package rmi.to_do;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class TodoListImpl extends UnicastRemoteObject implements TodoList {
    private final List<String> tasks;

    protected TodoListImpl() throws RemoteException {
        super();
        tasks = new ArrayList<>();
    }

    @Override
    public synchronized void addTask(String task) throws RemoteException {
        tasks.add(task);
    }

    @Override
    public synchronized void removeTask(String task) throws RemoteException {
        tasks.remove(task);
    }

    @Override
    public synchronized List<String> getTasks() throws RemoteException {
        return new ArrayList<>(tasks);
    }
}
