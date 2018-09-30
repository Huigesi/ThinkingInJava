package Exercise.annotations;

import Exercise.OSExecute;
import Exercise.atunit.Test;
import Exercise.atunit.TestObjectCleanup;
import Exercise.atunit.TestObjectCreate;
import Exercise.atunit.TestProperty;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class AtUnitExample5 {
    private String text;

    public AtUnitExample5(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    @TestProperty
    static PrintWriter output;
    @TestProperty
    static int counter;

    @TestObjectCreate
    static AtUnitExample5 create() {
        String id = Integer.toString(counter++);
        try {
            output = new PrintWriter("Test" + id + ".txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new AtUnitExample5(id);
    }

    @TestObjectCleanup
    static void cleanup(AtUnitExample5 tobj) {
        System.out.println("Running cleanup");
        output.close();
    }

    @Test
    boolean test1() {
        output.print("test1");
        return true;
    }

    @Test
    boolean test2() {
        output.print("test2");
        return true;
    }

    @Test
    boolean test3() {
        output.print("test3");
        return true;
    }

    public static void main(String[] args) {
        OSExecute.command(
                "java atunit.AtUnit AtUnitExample5"
        );
    }
}
