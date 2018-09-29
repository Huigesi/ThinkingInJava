package Exercise.annotations;

import Exercise.OSExecute;
import Exercise.atunit.Test;
import Exercise.atunit.TestObjectCreate;

public class AtUnitExample13 {
    private int n;

    public AtUnitExample13(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public String methodOne() {
        return "This is methodOne";
    }

    public int methodTwo() {
        System.out.println("This is methodTwo");
        return 2;
    }

    @TestObjectCreate
    static AtUnitExample13 create() {
        return new AtUnitExample13(47);
    }

    @Test
    boolean initialization() {
        return n == 47;
    }

    @Test
    boolean methodOneTest() {
        return methodOne().equals("This is methodOne");
    }

    @Test
    boolean m2() {
        return methodTwo() == 2;
    }

    public static void main(String[] args) {
        OSExecute.command(
                "java net.mindview.atunit.AtUnit AtUnitExample3"
        );
    }

}
