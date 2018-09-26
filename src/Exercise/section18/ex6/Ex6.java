package Exercise.section18.ex6;

import Exercise.ProcessFiles;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex6 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: directory data(mm/dd/yyyy");
            System.out.println(
                    "(Outputs a listing of all java files in the given directory"
                            + "\n that were last modified on or after the given date.)");
            return;
        }
        final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        new ProcessFiles(new ProcessFiles.Strategy() {
            @Override
            public void process(File file) {
                Date modDate = new Date(file.lastModified());
                try {
                    {
                        if (modDate.after(sdf.parse(args[1]))){
                            System.out.println(file);
                        }
                    }
                } catch (ParseException e) {
                    System.out.println(e.getMessage());
                }
            }
        },"java").start(args);
    }
}
