package Exercise.section18.ex4;

import Exercise.Directory;

import java.io.File;

public class Ex4 {
    public static void main(String[] args) {
        long sum=0;
        if (args.length == 0) {
            for (File file : Directory.walk(".").mFiles) {
                System.out.println(file+": ");
                System.out.println(file.length());
                sum+=file.length();
            }
        }else {
            for (String arg : args) {
                for (File file : Directory.walk(".", arg).mFiles) {
                    System.out.println(file+": ");
                    System.out.println(file.length());
                    sum+=file.length();
                }
                System.out.println();
            }
        };
        System.out.println(sum);
    }
}
