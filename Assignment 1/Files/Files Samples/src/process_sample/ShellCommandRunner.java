package process_sample;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ShellCommandRunner {
    public static void main(String[] args) {
        String command = "ping";
        String argument = "google.com";

        ProcessBuilder processBuilder = new ProcessBuilder(command, argument);
        Process process;
        try {
            process = processBuilder.start();
            process.waitFor(10, TimeUnit.SECONDS);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException();
        }

        int exitCode = process.exitValue();
        if (exitCode != 0) {
            System.err.println("Error running command.");
            System.err.println("Exit code: " + exitCode + ".");
        } else {
            System.out.println("Command executed successfully.");
        }
    }

}
