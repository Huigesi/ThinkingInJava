package section8.Rodent14;

public class Shared {
    private int refcount = 0;
    private static long counter = 0;
    private final long id = counter++;
    public Shared() { System.out.println("Creating " + this); }
    public void addRef() { refcount++; }
    public String toString() { return "Shared " + id; }
    public void showRefcount() { System.out.println("refcount = " + refcount); }
}