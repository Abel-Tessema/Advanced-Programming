package threads.chess;

public class Timer {
    private long startTime;
    private String name;

    public Timer(String name) {
        this.name = name;
        this.startTime = System.currentTimeMillis();
    }

    public void stop() {
        long endTime = System.currentTimeMillis();
        System.out.println(name + " took " + (endTime - startTime) + " ms");
    }
}
