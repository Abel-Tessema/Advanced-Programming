package threads.counter;

public class MultiThreadedCounter {
    public static void main(String[] args) {
        int numThreads = 3; // Number of threads
        int maxCount = 10; // Maximum count per thread

        for (int i = 1; i <= numThreads; i++) {
            Counter counter = new Counter(maxCount);
            counter.setName("Thread " + i);
            counter.start();
        }
    }
}
