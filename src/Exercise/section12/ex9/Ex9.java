package Exercise.section12.ex9;

public class Ex9 {
    public static void f(int i) throws Exception1,Exception2,Exception3{
        if (i<0) throw new Exception1("i<0");
        if (i>0) throw new Exception2("i>0");
        if (i==0) throw new Exception3("i==0");
    }

    public static void main(String[] args) {
        try {
            f(0);
            f(-1);
            f(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class Exception1 extends Exception{
    public Exception1(String s) {
        super(s);
    }
}
class Exception2 extends Exception{
    public Exception2(String s) {
        super(s);
    }
}
class Exception3 extends Exception{
    public Exception3(String s) {
        super(s);
    }
}
