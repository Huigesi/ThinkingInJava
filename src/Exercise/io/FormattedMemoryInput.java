package Exercise.io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class FormattedMemoryInput {
    public static void main(String[] args) throws IOException {
        DataInputStream in=new DataInputStream(
                new ByteArrayInputStream(
                        BufferedInputFile.read("FormattedMemoryInput.java").getBytes()
                )
        );
        while (true) {
            System.out.println((char) in.readByte());
        }
    }
}
