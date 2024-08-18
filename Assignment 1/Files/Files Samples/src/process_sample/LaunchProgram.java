package process_sample;

import java.io.IOException;

public class LaunchProgram {
    public static void main(String[] args) {
        String programPath = "C:/Windows/notepad.exe";
        String[] arguments = {"-1"};
        Process process;

        try {
            process = Runtime.getRuntime().exec(programPath, arguments);
            process.waitFor();
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }

        int exitCode = process.exitValue();
        if (exitCode != 0) {
            System.err.println("Error launching the program.");
            System.err.println("Exit code: " + exitCode + ".");
        } else {
            System.out.println("Program executed successfully.");
        }
    }
}
