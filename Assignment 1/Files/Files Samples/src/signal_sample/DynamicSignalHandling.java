package signal_sample;

import sun.misc.Signal;
import sun.misc.SignalHandler;

public class DynamicSignalHandling {
    private static void toggleSignalHandling(String signalName) {
        SignalHandler currentHandler = Signal.handle(new Signal(signalName), SignalHandler.SIG_IGN);
        Signal.handle(new Signal(signalName), currentHandler == SignalHandler.SIG_IGN ? signal -> {
            System.out.println(signal.getName() + " is now being handled.");
            System.exit(0);
        } : SignalHandler.SIG_IGN);
    }

    public static void main(String[] args) throws InterruptedException {
        String signalName = "INT";
        toggleSignalHandling(signalName); // Initially ignore

        Thread.sleep(5000);
        System.out.println("Switching to handle the signal.");
        toggleSignalHandling(signalName); // Switch to handle

        while (true) {
            Thread.sleep(1000);
        }
    }
}
