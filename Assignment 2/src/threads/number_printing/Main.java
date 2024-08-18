package threads.number_printing;

public class Main {
    public static void main(String[] args) {
        // Create threads
        Thread thread1 = new Thread(new NumberPrinter(1, 5), "Thread-1");
        Thread thread2 = new Thread(new NumberPrinter(6, 10), "Thread-2");
        Thread thread3 = new Thread(new NumberPrinter(11, 15), "Thread-3");

        // Start threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
