package Exercise.section13.ex6;

public class Ex6 {
    public int i;
    public long l;
    public float f;
    public double d;

    public Ex6(int i, long l, float f, double d) {
        this.i = i;
        this.l = l;
        this.f = f;
        this.d = d;
    }

    public String toSting() {
        return String.format("%d---%s---%f---%s", i, l, f, d);
    }

    public static void main(String[] args) {
        Ex6 ex6 = new Ex6(1, 232323323, 1.002f, 1.22);
        System.out.println(ex6.toSting());
    }
}
