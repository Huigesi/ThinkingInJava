package Exercise.section15.ex14;

import Exercise.section15.BasicGenerator;
import Exercise.section15.CountedObject;
import Exercise.section15.Generator;

public class BasicGeneratorDemo {
    public static void main(String[] args) {
        Generator<CountedObject> gen = new BasicGenerator<>(CountedObject.class);
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }
    }
}
