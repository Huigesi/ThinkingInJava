package Exercise.section18.ex8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Ex7 {
    public static String readAndReverse(String filename) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        LinkedList<String> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null) {
            list.add(s);
        }
        while (list.peekLast() != null) {
            sb.append(list.pollLast()+"\n");
        }
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException{
        if (args.length != 1) {
            System.out.println("Usage: enter file name");
            System.exit(1);
        }
        System.out.println(readAndReverse(args[0]));
    }
}
