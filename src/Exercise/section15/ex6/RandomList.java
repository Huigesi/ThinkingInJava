package Exercise.section15.ex6;

import java.util.ArrayList;
import java.util.Random;

public class RandomList<T> {
    private ArrayList<T> storage = new ArrayList<>();
    private Random rand = new Random(47);

    public void add(T item) {
        storage.add(item);
    }

    public T select() {
        return storage.get(rand.nextInt(storage.size()));
    }

    public static void main(String[] args) {
        RandomList<String> rs = new RandomList<>();
        RandomList<Integer> ri = new RandomList<>();
        for (Integer i:new Integer[]{1,2,3,4,5,6}){
            ri.add(i);
        }
        for (String s:("The quick brown for jumped over "+
                "the lazy brown dog").split(" ")){
            rs.add(s);

        }
        for (int i = 0; i < 11; i++) {
            System.out.println(ri.select()+" ");
        }

    }
}
