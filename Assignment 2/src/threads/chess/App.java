package threads.chess;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Timer timer = new Timer("starter");

        final int size = 9;
        List<List<String>> solutions = new ArrayList<>();

        // Create and start worker threads
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Worker worker = new Worker(i, size, solutions);
            Thread thread = new Thread(worker);
            threads.add(thread);
            thread.start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//         Print the solutions
         for (List<String> combination : solutions) {
             for (String row : combination) {
                 System.out.println(row);
             }
             System.out.println("***********");
         }

        timer.stop();
    }
}
