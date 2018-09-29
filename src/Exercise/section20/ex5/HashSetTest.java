package Exercise.section20.ex5;

import Exercise.OSExecute;
import Exercise.atunit.Test;

import java.util.HashSet;

public class HashSetTest extends HashSet<String>{
    @Test
    void initialization() {
        assert this.isEmpty();
    }

    @Test
    void _contains() {
        this.add("one");
        assert this.contains("one");
    }

    @Test
    void _remove() {
        this.add("one");
        this.remove("one");
        assert this.isEmpty();
    }

    public static void main(String[] args) {
        OSExecute.command(
                "java net.mindview.atunit.AtUnit LinkedListTest"
        );
    }
}
