//
//public class Main {
//    public static void main(String[] args) {
//        // process signal file pipe
//        // 5 files/classes for each = 5 * 4 = 20
//        // Deadline: Monday evening
//
//    }
//}

import sun.misc.Signal;
import sun.misc.SignalHandler;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Create a signal handler
        SignalHandler handler = new SignalHandler() {
            @Override
            public void handle(Signal signal) {
                System.out.println("Received signal: " + signal.getName());
            }
        };
        // Register the signal handler for the TERM signal
        Signal.handle(new Signal("TERM"), handler);
        // Wait for the TERM signal
        Thread.sleep(Long.MAX_VALUE);
    }
}