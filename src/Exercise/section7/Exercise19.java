package Exercise.section7;

public class Exercise19 {
    private final Peo mpeo;
    public Exercise19(int x) {
        mpeo = new Peo(x);
    }

    public Exercise19() {
        mpeo = new Peo(1);
    }

    public static void main(String[] args) {
        Exercise19 e1 = new Exercise19();
        Exercise19 e2 = new Exercise19(47);
        System.out.println("e1.p"+e1.mpeo);
        System.out.println("e2.p"+e2.mpeo);
    }
}
class Peo{
    private int i;

    public Peo(int i) {
        this.i = i;
    }

    public String toString() {
        return ("peo "+i);
    }
}
