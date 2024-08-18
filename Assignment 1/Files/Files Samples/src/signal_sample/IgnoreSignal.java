package signal_sample;

import sun.misc.Signal;
import sun.misc.SignalHandler;

public class IgnoreSignal {

    public static void ignoreSignal(String signalName) {
        Signal.handle(new Signal(signalName), SignalHandler.SIG_IGN);
    }

    public static void main(String[] args) {
        ignoreSignal("INT"); // Ignore SIGINT

        System.out.println("SIGINT is ignored. Press Ctrl + C and observe that nothing happens.");
        System.out.println("To terminate it, close the terminal or find the exit button.");
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
