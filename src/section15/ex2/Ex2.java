package section15.ex2;
class Robot{
    private String name;

    public Robot(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
public class Ex2<T> {
    public T a,b,c;

    public Ex2(T a, T b, T c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String toString() {
        return a+" "+b+" "+c;
    }

    public static void main(String[] args) {
        Robot robota = new Robot("A");
        Robot robotb = new Robot("B");
        Robot robotc = new Robot("C");
        Ex2<Robot> robotEx2 = new Ex2<>(robota,robotb,robotc);
        System.out.println(robotEx2);
    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public T getB() {
        return b;
    }

    public void setB(T b) {
        this.b = b;
    }

    public T getC() {
        return c;
    }

    public void setC(T c) {
        this.c = c;
    }
}