package section7;

public class Exercise11{
    Cleanser cleanser=new Cleanser();

    public Cleanser getCleanser() {
        return cleanser;
    }

}
class Cleanser {
    private String s = "Cleanser";
    public void append(String a) { s += a; }
    public void dilute() { append(" dilute()"); }
    public void apply() { append(" apply()"); }
    public void scrub() { append(" scrub()"); }
    public String toString() { return s; }
    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        System.out.println(x);
    }
}