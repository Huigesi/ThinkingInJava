package section15.ex8;

import section15.Generator;

import java.util.Iterator;
import java.util.Random;

public class StoryCharactersGenerator implements Generator<StoryCharacters>,Iterable<StoryCharacters> {
    private Class[] types = {GoodGuys.class, BadGuys.class};
    private static Random rand = new Random(47);
    private int size=0;

    public StoryCharactersGenerator() {
    }

    public StoryCharactersGenerator(int size) {
        this.size = size;
    }

    class StoryCharactersIt implements Iterator<StoryCharacters>{
        int count=size;

        public boolean hasNext() {
            return count>0;
        }

        public StoryCharacters next() {
            count--;
            return StoryCharactersGenerator.this.next();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<StoryCharacters> iterator() {
        return new StoryCharactersIt();
    }

    @Override
    public StoryCharacters next() {
        try {
            return (StoryCharacters)types[rand.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        StoryCharactersGenerator gen = new StoryCharactersGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }
        for (StoryCharacters s : new StoryCharactersGenerator(5)) {
            System.out.println(s);
        }
    }
}
