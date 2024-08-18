package threads.number_printing;

class NumberPrinter implements Runnable {
    private final int start;
    private final int end;

    public NumberPrinter(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
            try {
                Thread.sleep(100); // Sleep for 100 milliseconds to simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
