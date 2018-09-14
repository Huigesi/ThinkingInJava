package Exercise.section12.ex1;

public class Ex1 {
    public static void f() throws Exception1{
        System.out.println("Throwing MyException from f()");
        throw new Exception1("from f()");
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (Exception1 exception1) {
            System.err.println("Caught Exception1");
            exception1.printStackTrace();
        }finally {
            System.out.println("made it to finally");
        }
    }
}

class Exception1 extends Exception {
    public Exception1(String msg) {
        super(msg);
        System.out.println("Exception1(String msg)");
    }
}
