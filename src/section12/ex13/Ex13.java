package section12.ex13;

public class Ex13 {
    public static void f(int i) throws Exception1, Exception2, Exception3 {
        if (i<0) throw new Exception1("i<0");
        if (i>0) throw new Exception2("i>0");
        if (i==0) throw new Exception3("i==0");
    }

    public static void main(String[] args) {
        try {
           /* f(0);
            f(-1);
            f(1);*/
            String s = null;
            f(Integer.valueOf(s));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("finally");
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
