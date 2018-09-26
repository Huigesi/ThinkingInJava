package Exercise.section18.ex21;

import java.io.*;

public class Ex21 {
    public static void main(String[] args)throws IOException {
        File file = new File("Ex21.java");
        BufferedInputStream inFile =
                new BufferedInputStream(
                        new FileInputStream(file)
                );
        System.setIn(inFile);
        BufferedReader stbin = new BufferedReader(
                new InputStreamReader(System.in)
        );
        String s;
        while ((s = stbin.readLine()) != null) {
            System.out.println(s.toUpperCase());
        }
    }
}
