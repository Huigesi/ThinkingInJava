package section7;

public class Exercise5 {
   /* public static void main(String[] args) {
        C c=new C();
    }*/
}
class Aa{
    public Aa() {
        System.out.println("A");
    }
}
class Bb{
    public Bb() {
        System.out.println("B");
    }
}
class C extends Aa{
    Bb b=new Bb();

    public C() {
        super();
    }

    public static void main(String[] args) {
        C c = new C();
    }
}