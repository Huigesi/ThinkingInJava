package Exercise.section12.ex10;

public class Ex10 {
    static void f() {
        try {
            g();
        } catch (Exception1 exception1) {
            exception1.printStackTrace();
            try {
                throw new Exception2();
            } catch (Exception2 exception2) {
                exception2.printStackTrace();
            }
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
