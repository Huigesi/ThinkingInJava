package Exercise.section18.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList {
    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length == 0) {
            list = path.list();
        }else {
            list = path.list(new DirFilter(args[0]));
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String item : list) {
            System.out.println(item);
        }
    }
}
class DirFilter implements FilenameFilter{
    private Pattern mPattern;

    public DirFilter(String pattern) {
        mPattern = Pattern.compile(pattern);
    }

    @Override
    public boolean accept(File dir, String name) {
        return mPattern.matcher(name).matches();
    }
}
