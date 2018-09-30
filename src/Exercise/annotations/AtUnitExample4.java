package Exercise.annotations;

import Exercise.OSExecute;
import Exercise.atunit.Test;
import Exercise.atunit.TestObjectCreate;
import Exercise.atunit.TestProperty;

import java.util.*;

public class AtUnitExample4 {
    static String theory = "All brontosauruses " +
            "are thin at one end,much MUCH thicker in the " +
            "middle, and then thin again at the far end.";
    private String word;
    private Random rand = new Random();

    public AtUnitExample4(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public String scrambleWord() {
        List<Character> chars = new ArrayList<>();
        for (Character c : word.toCharArray()) {
            chars.add(c);
        }
        Collections.shuffle(chars, rand);
        StringBuilder result = new StringBuilder();
        for (char ch : chars) {
            result.append(ch);
        }
        return result.toString();
    }

    @TestProperty
    static List<String> input = Arrays.asList(theory.split(" "));
    @TestProperty
    static Iterator<String> words = input.iterator();

    @TestObjectCreate
    static AtUnitExample4 create() {
        if (words.hasNext()) {
            return new AtUnitExample4(words.next());
        } else {
            return null;
        }
    }

    @Test
    boolean words() {
        System.out.println("'" + getWord() + "'");
        return getWord().equals("are");
    }

    @Test
    boolean scramble1() {
        rand = new Random(47);
        System.out.println("'" + getWord() + "'");
        String scrambled = scrambleWord();
        System.out.println(scrambled);
        return scrambled.equals("lAl");
    }

    @Test
    boolean scramble2() {
        rand = new Random(47);
        System.out.println("'" + getWord() + "'");
        String scrambled = scrambleWord();
        System.out.println(scrambled);
        return scrambled.equals("tsaeborornussu");
    }

    public static void main(String[] args) {
        System.out.println("starting");
        OSExecute.command(
                "java atunit.AtUnit AtUnitExample4"
        );
    }
}
