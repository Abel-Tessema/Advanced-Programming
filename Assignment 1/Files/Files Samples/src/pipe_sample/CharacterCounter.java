package pipe_sample;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class CharacterCounter {
    public static void main(String[] args) throws IOException {
        PipedWriter writer = new PipedWriter();
        PipedReader reader = new PipedReader(writer);

        writer.write("Alemitu, yet hedech bettewatu.");
        writer.close();

        int count = 0;
        while (reader.read() != -1) {
            count++;
        }
        reader.close();

        System.out.println("Character count: " + count);
    }
}
