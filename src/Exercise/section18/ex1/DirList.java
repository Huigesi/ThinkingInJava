package Exercise.section18.ex1;

import Exercise.TextFile;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.regex.Pattern;

public class DirList {
    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length < 2) {
            list = path.list();
        } else {
            list = path.list(new DirFilter(args[0],args));
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String item : list) {
            System.out.println(item);
        }
    }
}

class DirFilter implements FilenameFilter {
    private Pattern mPattern;
    private String[] mStrings;

    public DirFilter(String pattern,String[] args)
    {
        mPattern = Pattern.compile(pattern);
        mStrings = args;
    }

    @Override
    public boolean accept(File dir, String name) {
        return mPattern.matcher(name).matches() && !(Collections.disjoint(
                Arrays.asList(mStrings).subList(1, mStrings.length), new TextFile(name, "\\w+")
        ));
    }
}
