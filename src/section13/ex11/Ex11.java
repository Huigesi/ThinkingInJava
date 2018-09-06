package section13.ex11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex11 {
    public static void main(String[] args) {
        String str = "Arline ate eight apples and one orange while Anita hadn't any";
        String reg = "(?i)((^[aeiou])|(\\s+[aeiou]))\\w+[aeiou]\\b";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group()+"  "+matcher.start());
        }
    }
}
