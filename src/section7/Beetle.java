package section7;

class Insect{
    private int i=9;
    protected int j;

    Insect() {
        System.out.println("i = " + i + ",j = " + j);
        j=39;
    }

    private static int x1 = printInit("static Insect.x1 initialized");

    static int printInit(String s) {
        System.out.print(s+"   ");
        return 47;
    }
}
public class Beetle extends Insect{
    private int k = printInit("Beetle.k initialized");

    public Beetle() {
        System.out.println(" k = "+k);
        System.out.println("j = "+j);
    }

    private static int x2 = printInit("static Insect.x2 initialized");

}
class Scr extends Beetle{
    private int s=printInit("Scr.s initialized");

    public Scr() {
        System.out.println(" s = " +s);
        System.out.println(" j = " +j);
    }

    private static int x3 = printInit("static Insect.x3 initialized");

    public static void main(String[] args) {
        System.out.println(" Scr Beetle");
        Scr c = new Scr();
    }
}
