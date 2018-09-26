package Exercise.section18.ex18;

import Exercise.TextFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class TextFile18 extends ArrayList<String> {
    public static String read(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader in = new BufferedReader(
                new FileReader(
                        new File(fileName).getAbsoluteFile()
                )
        );
        try {
            String s;
            while ((s = in.readLine()) != null) {
                sb.append(s);
                sb.append("\n");
            }
        } finally {
            in.close();
        }
        return sb.toString();
    }
    public static void write(String fileName,String text) throws IOException {
        PrintWriter out = new PrintWriter(
                new File(fileName).getAbsoluteFile()
        );
        try {
            out.print(text);
        }finally {
            out.close();
        }
    }
    public TextFile18(String fileName, String splitter) throws IOException {
        super(Arrays.asList(read(fileName).split(splitter)));
        // Regular expression split() often leaves an empty
        // String at the first position:
        if(get(0).equals("")) remove(0);
    }
    public TextFile18(String fileName)throws IOException {
        this(fileName, "\n");
    }
    public void write(String fileName) throws IOException {
        PrintWriter out = new PrintWriter(
                new File(fileName).getAbsoluteFile()
        );
        try {
            for (String item : this) {
                out.println(item);
            }
        }finally {
            out.close();
        }
    }
    public static void main(String[] args) {
        try {
            String file = read("TextFile18.java");
            write("text.txt", file);
            TextFile18 text = new TextFile18("test.txt");
            text.write("test2.txt");
            TreeSet<String> words = new TreeSet<>(
                    new TextFile18("TextFile18.java", "\\W+")
            );
            System.out.println(words.headSet("a"));
        } catch (IOException e) {
            System.out.println("Caught "+e);
            e.printStackTrace();
        }
    }
}
