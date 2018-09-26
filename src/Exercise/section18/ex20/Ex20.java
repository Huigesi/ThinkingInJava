package Exercise.section18.ex20;

import Exercise.Directory;

import java.io.File;
import java.io.IOException;

import static Exercise.BinaryFile.read;

public class Ex20 {
    public static void main(String[] args) throws IOException {
        for (File file : Directory.walk(".", ".*\\.class").mFiles) {
            byte[] ba = read(file);
            for (int i = 0;i < 4; i++) {
                System.out.println(Integer.toHexString(ba[i]&0xff).toUpperCase());
            }
        }
    }
}
