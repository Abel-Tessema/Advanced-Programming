import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Process myProcess = Runtime.getRuntime().exec("notepad.exe test.txt");
        if (myProcess.isAlive()) {
            System.out.println("Process ID: " + myProcess.pid());
        }
    }
}