package section13.ex20;

import java.util.Scanner;

public class Ex20 {
    int mInt;
    long mLong;
    float mFloat;
    double mDouble;
    String mString;

    public Ex20(String s) {
        Scanner scanner = new Scanner(s);
        mInt=scanner.nextInt();
        mLong=scanner.nextLong();
        mFloat=scanner.nextFloat();
        mDouble=scanner.nextDouble();
        this.mString=scanner.next();
    }

    public String toString() {
        return "int : " + mInt + " long : " + mLong + " float : " + mFloat + " double : " + mDouble+" string : "+mString;
    }

    public static void main(String[] args) {
       Ex20 ex20=new  Ex20("17 56789 2.7 3.61412 hello");
        System.out.println(ex20);
    }
}
