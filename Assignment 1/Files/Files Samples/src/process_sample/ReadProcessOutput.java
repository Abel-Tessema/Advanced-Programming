package process_sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadProcessOutput {
    public static void main(String[] args) {
        String processName = "ipconfig";
        String arguments = "/all";

        ProcessBuilder processBuilder = new ProcessBuilder(processName, arguments);
        try {
            Process process = processBuilder.start();
            process.waitFor();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
