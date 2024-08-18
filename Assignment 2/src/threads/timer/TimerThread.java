package threads.timer;

import java.awt.Toolkit;

class TimerThread extends Thread {
    private final long seconds;

    public TimerThread(int seconds) {
        this.seconds = seconds;
    }

    public void run() {
        try {
            // Sleep for the specified time limit
            Thread.sleep(seconds * 1000L);
            // Play alarm sound
            playBeepSound();
        } catch (InterruptedException e) {
            System.out.println("Timer interrupted");
        }
    }

    private void playBeepSound() {
        // Use the default beep sound from the AWT Toolkit
        Toolkit.getDefaultToolkit().beep();
        System.out.println("Time's up!");
    }
}
