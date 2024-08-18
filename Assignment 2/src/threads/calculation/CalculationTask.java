package threads.calculation;

import java.util.Random;

public class CalculationTask implements Runnable {

    private final int upperLimit;
    private final String taskName;
    private final static Random generator = new Random();

    public CalculationTask(String name) {
        taskName = name;
        upperLimit = generator.nextInt(1000); // Random number between 0 and 999
    }

    @Override
    public void run() {
        try {
            System.out.printf("%s starting calculation up to %d. \n", taskName, upperLimit);
            long sum = 0;
            for (int i = 1; i <= upperLimit; i++) {
                sum += i;
            }
            System.out.printf("%s calculation result: %d. \n", taskName, sum);
        } catch (Exception e) {
            System.out.printf("%s %s \n", taskName, "terminated prematurely due to an exception");
        }
    }
    // end of method run

    public static void main(String[] args) {
        CalculationTask taskOne = new CalculationTask("Task one");
        CalculationTask taskTwo = new CalculationTask("Task two");
        CalculationTask taskThree = new CalculationTask("Task three");

        Thread threadOne = new Thread(taskOne);
        Thread threadTwo = new Thread(taskTwo);
        Thread threadThree = new Thread(taskThree);

        threadOne.start();
        threadTwo.start();
        threadThree.start();
    }
}
