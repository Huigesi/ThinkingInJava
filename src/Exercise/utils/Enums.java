package Exercise.utils;

import java.util.Random;

public class Enums {
    private static Random rand = new Random(47);

    public static <T extends Enum<T>> T random(Class<T> ec) {
        return random(ec.getEnumConstants());
    }

    private static <T extends Enum<T>> T random(T[] values) {
        return values[rand.nextInt(values.length)];
    }
}
