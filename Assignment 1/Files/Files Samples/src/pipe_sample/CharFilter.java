package pipe_sample;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class CharFilter {
    public static void main(String[] args) throws IOException {
        PipedWriter writer = new PipedWriter();
        PipedReader reader = new PipedReader(writer);

        String message = "The quick brown fox jumps over the lazy dog";
        writer.write(message.toCharArray());
        writer.close();

        StringBuilder filtered = new StringBuilder();
        int character;
        while ((character = reader.read()) != -1) {
            if (!"aeiouAEIOU".contains(String.valueOf((char) character))) {
                filtered.append((char) character);
            }
        }
        reader.close();

        System.out.println("Original: " + message);
        System.out.println("Filtered (consonants): " + filtered);
    }
}
