package Exercise.section7;
import java.util.*;


class Test {
    Test() {
        System.out.println("Test()"); }
}

public class Exercise18 {
    private String name;
    public Exercise18(String s) { name = s;  }
    static final Test sft = new Test(); // constant reference address
    private final Test ft = new Test();
    static final String SFS = "static final"; // class constant
    private final String fs = "final";
    private static Random rand = new Random();
    static final int SFI = rand.nextInt(); // class constant
    private final int fi = rand.nextInt();
    public String toString() {
        return (name + ": " + sft + ", " + ft + ", " + SFS + ", " + fs + ", " + SFI + ", " + fi);
    }
    public static void main(String[] args) {
        Exercise18 d1 = new Exercise18("d1");
        Exercise18 d2 = new Exercise18("d2");
        Exercise18 d3 = new Exercise18("d3");
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
    }
}