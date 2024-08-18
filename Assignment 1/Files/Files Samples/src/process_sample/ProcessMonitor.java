package process_sample;

public class ProcessMonitor {
    public static void main(String[] args) throws InterruptedException {
        String processName = "Telegram.exe";

        while (true) {
            boolean found = false;
            for (ProcessHandle handle : ProcessHandle.allProcesses().toList()) {
                if (
                        handle.info().command().isPresent() &&
                        handle.info().command().get().contains(processName)
                ) {
                    found = true;
                    break;
                }
            }
            if (found) {
                System.out.println("Process " + processName + " is running.");
            } else {
                System.out.println("Process " + processName + " is not running.");
            }
            Thread.sleep(2_000);
        }
    }
}
