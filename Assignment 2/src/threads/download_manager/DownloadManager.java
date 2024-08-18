package threads.download_manager;

class DownloadManager extends Thread {
    private String file;

    public DownloadManager(String file) {
        this.file = file;
    }

    public void run() {
        System.out.println("Downloading " + file + " started...");
        // Simulate downloading by sleeping for a random time
        try {
            Thread.sleep((long) (Math.random() * 5000)); // Random sleep time up to 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Downloading " + file + " completed.");
    }
}
