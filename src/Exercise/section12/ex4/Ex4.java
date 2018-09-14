package Exercise.section12.ex4;

public class Ex4 {
    public static void f() throws Exception3 {
        System.out.println("f()");
        throw new Exception3("out of ex4");
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (Exception3 exception3) {
            exception3.printStackTrace();
            exception3.showS();
        }
    }
}

class Exception3 extends Exception {
    private String s;
    public Exception3(String s) {
        this.s=s;
    }

    protected void showS() {
        System.out.println(s);
    }
}
