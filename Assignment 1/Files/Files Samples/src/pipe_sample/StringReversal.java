package pipe_sample;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class StringReversal {
    public static void main(String[] args) throws IOException {
        PipedWriter writer = new PipedWriter();
        PipedReader reader = new PipedReader(writer);

        String original = "Tilahun Gessesse";
        writer.write(original.toCharArray());
        writer.close();

        StringBuilder reversed = new StringBuilder();
        int character;
        while ((character = reader.read()) != -1) {
            reversed.insert(0, (char) character);
        }
        reader.close();

        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);
    }
}
