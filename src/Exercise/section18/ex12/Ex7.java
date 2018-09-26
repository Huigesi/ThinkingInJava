package Exercise.section18.ex12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class Ex7 {
    public static String readAndReverse(String filename) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        LinkedList<String> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        String[] temp=filename.split("\\.");
        String file = temp[0] + "Reversed." + temp[1];
        PrintWriter out = new PrintWriter(file);
        int lineCount=1;
        while ((s = in.readLine()) != null) {
            list.add(lineCount+""+s);
        }
        while (list.peekLast() != null) {
            String t=list.pollLast();
            out.println(t);
            sb.append(t+"\n");
        }
        in.close();
        out.close();
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
