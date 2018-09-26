package Exercise.section18.ex3;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList3 {
    public static void main(String[] args) {
        File path = new File(".");
        File[] files;
        if (args.length == 0) {
            files = path.listFiles();
        }else {
            files = path.listFiles(new FileFilter() {
                private Pattern mPattern = Pattern.compile(args[0]);
                @Override
                public boolean accept(File file) {
                    return mPattern.matcher(file.getName()).matches();
                }
            });
        }
        Arrays.sort(files);
        long sum=0;
        for (File item : files) {
            System.out.println(item+":");
            System.out.println(files.length);
            sum += files.length;
        }
        System.out.println(sum);
    }
}
