package signal_sample;

import sun.misc.Signal;

public class CleanupOnSignal {

    public static void performCleanup() {
        System.out.println("Performing cleanup operations...");
        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Signal.handle(new Signal("INT"), signal -> {
            performCleanup();
            System.out.println("Cleanup completed. Exiting now.");
            System.exit(0);
        });

        System.out.println("Application running. Press Ctrl + C to stop.");
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
