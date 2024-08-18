package threads.counter;

class Counter extends Thread {
    private int maxCount;

    public Counter(int maxCount) {
        this.maxCount = maxCount;
    }

    public void run() {
        for (int i = 1; i <= maxCount; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(100); // Sleep for 100 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
