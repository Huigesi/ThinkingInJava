package Exercise;

public class Section5 {
    public static class Exercise1 {
        String a;
    }

    public static class Exercise2 {
        String a = "2";

        public Exercise2(String a) {
            this.a = a;
        }
    }

    public static class Exercise3 {
        public Exercise3() {
            System.out.println("no args");
        }

        //exercise4
        public Exercise3(String s) {
            System.out.println("args " + s);
        }
    }

    //exercise5
    public static class Dog {
        void bark(int a) {
            System.out.println("bark(int)");
        }

        void bark(double a) {
            System.out.println("bark(String)");
        }

        void bark(float a) {
            System.out.println("bark(float)");
        }

    }

    public static class Exercise8 {
        public void f1() {
            f2();
            this.f2();
        }

        public static void f2() {
            System.out.println("f2");
        }
    }

    public static class Exercise10 {

        protected void finalize() {
            System.out.println("e10");
        }
    }

    //Exercise12
    public static class Tank {
        boolean isEmpty = true;

        public Tank(boolean isEmpty) {
            this.isEmpty = isEmpty;
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            if (isEmpty == true) {
                System.out.println("isEmpty");
            } else {
                System.out.println("noEmpty");
            }
        }
    }

    //Exercise16
    public static String[] strList = {"a", "b", "c", "d"};

    //Exercise17

    static class Exercise17 {
        public Exercise17(String s) {
            System.out.println(s);
        }
    }

    public static void pmain() {
        Exercise17[] exercise17s = new Exercise17[2];
        for (Exercise17 e : exercise17s) {
            e = new Exercise17("a");
        }
    }
    //exercise19
    static class Exercise19{
        static void f(String... args) {
            for (String i : args) {
                System.out.println(i);
            }
        }
    }

    //exercise20
    static void main2(String... args) {
        for (String i : args) {
            System.out.println(i);
        }
    }

    //exercise21
    public enum money{
        LITAS,
        ZIMBABWEA
    }

    public static void main(String[] args) {
        /*Exercise1 e1=new Exercise1();
        System.out.println(e1.a);
        Exercise2 e2 = new Exercise2("1");
        System.out.println(e2.a);
        Exercise3 e3 = new Exercise3();
        Exercise3 e4 = new Exercise3("exercise4");
        Dog dog=new Dog();
        dog.bark(5);
        dog.bark(5);
        dog.bark(5);
        Exercise8 e8 = new Exercise8();
        e8.f1();
        new Exercise10();
        System.gc();*/
        //new Tank(true);
        new Tank(false);
        //Exercise.Cups.cup1.f(99);
        //new Exercise.Exercise14("11","asdd").printstr();
        for (String s : strList) {
            //System.out.println(s);
        }
        //pmain();
        //Exercise19.f("a","b","c");
        //Exercise19.f(new String[] {"a","b","c"});
        main2("a");
    }
    //static Exercise.Cups cups1=new Exercise.Cups();
    //static Exercise.Cups cups2=new Exercise.Cups();
}

//Exercise13
class Cup {
    Cup(int maker) {
        System.out.println("Exercise.Cup(" + maker + ")");
    }

    void f(int maker) {
        System.out.println("f(" + maker + ")");
    }
}

class Cups {
    static Cup cup1;
    static Cup cup2;

    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }

    Cups() {
        System.out.println("Exercise.Cup()");
    }
}

//Exercise.Exercise14
class Exercise14 {
    static String str1 = "str1";
    static String str2;

    static {
        str2 = "sr2";
        System.out.println(str2);
    }

    public Exercise14(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
    }

    public static void printstr() {
        System.out.println(str1 + " " + str2);
    }
}
