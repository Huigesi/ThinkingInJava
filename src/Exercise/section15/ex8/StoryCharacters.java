package Exercise.section15.ex8;

public class StoryCharacters {
    private static long counter=0;
    private final long id = counter++;

    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}
