package Exercise.section18.ex1;

import Exercise.TextFile;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Pattern;

public class DirList3 {
    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length < 2) {
            list = path.list();
            System.out.println( "Usage: enter filtering regex");

                    //("followed by words, one or more of which each file must contain."););
        }else {
            list = path.list(new FilenameFilter() {
                private Pattern mPattern = Pattern.compile(args[0]);
                @Override
                public boolean accept(File dir, String name) {
                    return mPattern.matcher(name).matches() && !(Collections.disjoint(
                            Arrays.asList(args).subList(1, args.length),
                            new TextFile(name, "\\W+")
                    ));
                }
            });
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String item : list) {
            System.out.println(item);
        }
    }
}
