package Exercise.section19.ex2;


import java.util.Random;
enum CartoonCharacter {
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;
    private static Random rand = new Random();
    public static CartoonCharacter next() {
        return values()[rand.nextInt(values().length)];
    }
}

public class EnumImplementation {

    public static void main(String[] args) {
        CartoonCharacter cc=CartoonCharacter.BOB;
        for (int i = 0; i < 10; i++) {
            System.out.println(cc.next());
        }
    }
}
