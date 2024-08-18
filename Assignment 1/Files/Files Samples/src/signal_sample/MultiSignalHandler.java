package signal_sample;

import sun.misc.Signal;

public class MultiSignalHandler {

    public static void handleSignal(String signalName) {
        Signal.handle(new Signal(signalName), signal -> {
            System.out.printf("Received %s. Exiting...\n", signal.getName());
            System.exit(0);
        });
    }

    public static void main(String[] args) {
        handleSignal("INT");
        handleSignal("TERM");

        System.out.println("Waiting for SIGINT or SIGTERM...");
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
