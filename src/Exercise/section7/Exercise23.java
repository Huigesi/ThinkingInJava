package Exercise.section7;

class A23 {
    static int j = printInit("A23.j initialized");

    static int printInit(String s) {
        System.out.println(s);
        return 1;
    }

    A23() {
        System.out.println("A23() constructor");
    }
}

class B23 extends A23 {
    static int k = printInit("B23.k initialized");

    B23() {
        System.out.println("B23() constructor");
    }
}

class C23 {
    static int n = printInitC23("C23.n initialized");
    static A23 a = new A23();

    C23() {
        System.out.println("C23() constructor");
    }

    static int printInitC23(String s) {
        System.out.println(s);
        return 1;
    }
}

class D23 {
    D23() {
        System.out.println("D23() constructor");
    }
}

public class Exercise23 extends B23 {
    static int i = printInit("LoadClass.i initialized");

    Exercise23() {
        System.out.println("LoadClass() constructor");
    }

    public static void main(String[] args) {
        // accessing static main causes loading (and initialization)
        // of A, B, & LoadClass
        System.out.println("hi");
        // call constructors from loaded classes:
        Exercise23 lc = new Exercise23();
        // call to static field loads & initializes C:
        System.out.println(C23.a);
        // call to constructor loads D:
        D23 d = new D23();
    }
}