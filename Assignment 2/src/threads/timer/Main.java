package threads.timer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the time limit from the user
        System.out.print("Enter the time limit in seconds: ");
        int timeLimit = scanner.nextInt();

        // Create and start the timer thread
        TimerThread timerThread = new TimerThread(timeLimit);
        timerThread.start();

        // Main thread prints a message
        System.out.println("Timer started for " + timeLimit + " seconds.");
    }
}
