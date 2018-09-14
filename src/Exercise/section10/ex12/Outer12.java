package Exercise.section10.ex12;
interface Inner12 {
    void modifyOuter();
}

public class Outer12 {
    private int oi = 1;
    private void hi() { System.out.println("Outer hi"); }
    public Inner12 inner() {
        return new Inner12() {
            public void modifyOuter() {
                oi *= 2;
                hi();
            }
        };
    }
    public void showOi() { System.out.println(oi); }
    public static void main(String[] args) {
        Outer12 out = new Outer12();
        out.showOi();
        out.inner().modifyOuter();
        out.showOi();
    }
}