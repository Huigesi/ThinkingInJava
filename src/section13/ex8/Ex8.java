package section13.ex8;

import java.util.Arrays;

public class Ex8 {
    public static String kni=
            "Then, when you have found the shrubbery, you must " +
            "cut down the mightiest tree in the forest... " +
            "with... a herring!";

    public static void main(String[] args) {
        String[] str=kni.split("the|you");
        System.out.println(Arrays.toString(kni.split("the|you")));
    }
}
