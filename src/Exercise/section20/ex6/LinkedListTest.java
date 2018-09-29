package Exercise.section20.ex6;

import Exercise.OSExecute;
import Exercise.atunit.Test;

import java.util.HashSet;
import java.util.LinkedList;

public class LinkedListTest {
    LinkedList<String> testObject = new LinkedList<>();

    @Test
    void initialization() {
        assert testObject.isEmpty();
    }

    @Test
    void _contains() {
        testObject.add("one");
        assert testObject.contains("one");
    }

    @Test
    void _remove() {
        testObject.add("one");
        testObject.remove("one");
        assert testObject.isEmpty();
    }

    public static void main(String[] args) {
        OSExecute.command(
                "java net.mindview.atunit.AtUnit LinkedListTest"
        );
    }
}
