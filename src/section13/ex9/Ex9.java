package section13.ex9;

import java.util.Arrays;

public class Ex9 {
    public static String kni=
            "Then, when you have found the shrubbery, you must " +
            "cut down the mightiest tree in the forest... " +
            "with... a herring!";

    public static void main(String[] args) {
        String reg = "[aeiouAEIOU]";
        System.out.println(kni.replaceAll(reg,"_"));
    }
}
