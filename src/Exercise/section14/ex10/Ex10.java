package Exercise.section14.ex10;

public class Ex10 {
    public static void chars(char[] c) {
        System.out.println("Superclass of char[] c: " +
                c.getClass().getSuperclass());
        System.out.println("char[] c instanceof Object: " +
                (c instanceof Object));
    }
    public static void main(String[] args) {
        char[] c = new char[10];
        chars(c);
        char c1 = 01;
    }
}
