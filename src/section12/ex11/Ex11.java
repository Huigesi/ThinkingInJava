package section12.ex11;

public class Ex11 {
    static void f() {
        try {
            g();
        } catch (Exception1 exception1) {
            exception1.printStackTrace();
            throw new RuntimeException(exception1);
        }
    }

    static void g() throws Exception1 {
        throw new Exception1();
    }

    public static void main(String[] args) {
        f();
    }
}

class Exception1 extends Exception{
    public Exception1() {

    }
}

class Exception2 extends Exception{
    public Exception2() {

    }
}
