package Exercise.section18.ex2;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class SortedDirList2 {
    private String[] dirList;

    public SortedDirList2(File dir) {
        this.dirList = dir.list();
        Arrays.sort(dirList, String.CASE_INSENSITIVE_ORDER);
    }

    public String[] list() {
        return dirList;
    }

    public String[] list(String regex) {
        Pattern pattern = Pattern.compile(regex);
        ArrayList<String> strings = new ArrayList<>();
        int count=0;
        for (String s : dirList) {
            if (pattern.matcher(s).matches()) {
                count++;
                strings.add(s);
            }
        }
        return strings.toArray(new String[count]);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : dirList) {
            stringBuilder.append(s + '\n');
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        SortedDirList2 sortedDirList2 = new SortedDirList2(new File("."));
        System.out.println(sortedDirList2);
        for (String s : sortedDirList2.list()) {
            System.out.println(s);
        }
        for (String s : sortedDirList2.list(".+\\.java")) {
            System.out.println(s);
        }
    }

}
