package threads.download_manager;

public class ConcurrentDownload {
    public static void main(String[] args) {
        String[] filesToDownload = {"File1", "File2", "File3", "File4", "File5"};

        System.out.println("Initiating concurrent downloads...");
        for (String file : filesToDownload) {
            DownloadManager downloadManager = new DownloadManager(file);
            downloadManager.start();
        }
        System.out.println("All downloads initiated.");
    }
}
