package Exercise.section18.ex10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Ex10 {
    public static String readAndFind(String[] filename) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(filename[0]));
        String s;
        LinkedList<String> find = new LinkedList<>();
        for (String t : filename) {
            find.add(t);
        }
        find.remove(0);
        LinkedList<String> list = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        while ((s = in.readLine()) != null) {
            List<String> line= Arrays.asList(s.split("\\W+"));
            if (!(Collections.disjoint(line,find))){
                list.add(s);
            }
        }
        while (list.peekLast() != null) {
            stringBuilder.append(list.pollLast() + "\n");
        }
        in.close();
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws IOException{
        if (args.length < 2) {
            System.out.println("Usage: enter file name");
            System.exit(1);
        }
        System.out.println(readAndFind(args));
    }
}
