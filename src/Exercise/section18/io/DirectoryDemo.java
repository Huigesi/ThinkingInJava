package Exercise.section18.io;

import Exercise.Directory;
import Exercise.PPrint;

import java.io.File;

public class DirectoryDemo {
    public static void main(String[] args) {
        PPrint.pPrint(Directory.walk(".").dirs);
        for (File file : Directory.local(".", "T.")) {
            System.out.print(file);
        }
        System.out.println("-------------");
        for (File file : Directory.walk(".", "T.*")) {
            System.out.print(file);
        }
        System.out.println("-------------");
        for (File file:Directory.walk(".","T.*\\.java")){
            System.out.println(file);
        }
        System.out.println("=============");
        for (File file : Directory.walk(".", ".*[Zz].*\\.class")) {
            System.out.print(file);
        }
    }
}
