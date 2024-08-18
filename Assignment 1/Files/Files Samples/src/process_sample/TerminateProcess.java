package process_sample;

public class TerminateProcess {
    public static void main(String[] args) {
        String processName = "Notepad.exe";

        for (ProcessHandle handle : ProcessHandle.allProcesses().toList()) {
            if (
                    handle.info().command().isPresent() &&
                    handle.info().command().get().contains(processName)
            ) {
                handle.destroyForcibly();
                System.out.println("Process " + processName + " terminated.");
                return;
            }
        }
        System.err.println("Process " + processName + " not found.");
    }
}
