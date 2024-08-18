package signal_sample;

import sun.misc.Signal;

public class GracefulShutdown {

    public static void setupSignalHandler() {
        Signal.handle(new Signal("INT"), signal -> {
            System.out.println("SIGINT received. Performing graceful shutdown...");
            System.exit(0);
        });
    }

    public static void main(String[] args) {
        setupSignalHandler();
        while (true) {
            try {
                Thread.sleep(1000); // Simulate long-running process
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
