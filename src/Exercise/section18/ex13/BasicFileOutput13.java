package Exercise.section18.ex13;

import Exercise.section18.io.BufferedInputFile;

import java.io.*;

public class BasicFileOutput13 {
    static String file = "BasicFileOutput13.out";

    public static void main(String[] args) throws IOException {
        LineNumberReader in = new LineNumberReader(
                new FileReader("BasicFileOutput13.java"));
        PrintWriter out = new PrintWriter(file);
        String s;
        while ((s = in.readLine()) != null) {
            out.println(in.getLineNumber() +": "+s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(file));
    }
}
