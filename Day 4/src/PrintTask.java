import java.util.Random;

public class PrintTask implements Runnable {
    private final int sleepTime;
    private final String taskName;
    private final static Random generator = new Random();

    public PrintTask(String taskName) {
        this.taskName = taskName;
        this.sleepTime = generator.nextInt(5_000);
    }

    @Override
    public void run() {
        try {
            System.out.printf("%s is going to sleep for %d milliseconds.\n", taskName, sleepTime);
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            System.out.printf("%s %s\n", taskName, "terminated prematurely due to an interruption.");
        }
        System.out.printf("%s is done sleeping.\n", taskName);
    }

    public static void main(String[] args) {
        PrintTask task1 = new PrintTask("Task 1");
        PrintTask task2 = new PrintTask("Task 2");
        PrintTask task3 = new PrintTask("Task 3");

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}