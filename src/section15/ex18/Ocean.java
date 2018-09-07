package section15.ex18;

import section15.Generator;
import section15.ex13.Generators13;
import sun.nio.cs.Surrogate;

import java.util.*;

class BigFish{
    private static long counter=1;
    private final long id=counter++;

    public BigFish() {
    }
    public String toString(){
        return "BigFish "+id;
    }

    public static Generator<BigFish> generator() {
        return new Generator<BigFish>() {
            @Override
            public BigFish next() {
                return new BigFish();
            }
        };
    }
}
class LittleFish{
    private static long counter=1;
    private final long id=counter++;

    public LittleFish() {
    }
    public String toString(){
        return "LittleFish "+id;
    }
    public static Generator<LittleFish> generator() {
        return new Generator<LittleFish>() {
            @Override
            public LittleFish next() {
                return new LittleFish();
            }
        };
    }
}
public class Ocean {
    public static void serve(LittleFish l,BigFish b){
        System.out.println(b+" eat "+l);
    }

    public static void main(String[] args) {
        Random random = new Random(47);
        Queue<BigFish> line = new LinkedList<>();
        Generators13.fill(line, BigFish.generator(), 10);
        List<LittleFish> littleFish = new ArrayList<>();
        Generators13.fill(littleFish, LittleFish.generator(), 14);
        for (BigFish b : line) {
            serve(littleFish.get(random.nextInt(littleFish.size())),b);
        }
    }
}
