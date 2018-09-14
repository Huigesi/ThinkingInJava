package Exercise;

import java.lang.reflect.Array;
import java.util.Arrays;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util.println;
import static sun.misc.Version.print;

public class Section4exercise8 {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0:
                    //println("1");
                case 1:
                    //println("2");
            }
        }
        //fibonacci(12);
        vampire();
    }

    //exercise9
    public static void fibonacci(int count) {
        int[] a = new int[count];
        a[0] = a[1] = 1;
        for (int i = 0; i <a.length; i++) {
            if (i == 0) {
                println(a[0] + ",");
            } else if (i == 1) {
                println(a[1] + ",");
            } else {
                a[i] = a[i - 1] + a[i - 2];
                if (i == a.length-1) {
                    println(a[i] + "");
                } else {
                    println(a[i] + ",");
                }
            }
        }
    }
    //exercise10
    public static void vampire(){
        String[] tagretNum = null;
        String[] gunNum=null;
        for (int i = 10; i < 100; i++) {
            for (int j = i + 1; j < 100; j++) {
                int target = i * j;
                if (target < 1000 || target > 10000) {
                    continue;
                }
                tagretNum=String.valueOf(target).split("");
                gunNum=(String.valueOf(i)+String.valueOf(j)).split("");
                Arrays.sort(tagretNum);
                Arrays.sort(gunNum);
                if (Arrays.equals(tagretNum, gunNum)) {
                    println(target+"="+i+"*"+j);
                }
            }
        }
    }
}
