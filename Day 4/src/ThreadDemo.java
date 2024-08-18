public class ThreadDemo extends Thread {
    @Override
    public void run() {
        System.out.println("Yipeeee!");
    }

    public static void main(String[] args) {
        ThreadDemo thread = new ThreadDemo();
        thread.start();
    }
}
