package section13.ex11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx11 {
    public static void main(String[] args) {
        Pattern p =
                Pattern.compile("(?i)((^[aeiou])|(\\s+[aeiou]))\\w+[aeiou]\\b");
        Matcher m = p.matcher("Arline ate eight apples and one orange while Anita hadn't any");
        while (m.find())
            System.out.println("Match \"" + m.group() + "\" at " + m.start());
    }
}