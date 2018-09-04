package section10.ex7;

class Outer7 {
    private int oi = 1;
    private void hi() { System.out.println("Outer hi"); }
    class Inner {
        private int s=2;
        void modifyOuter() {
            oi *= 2;
            hi();
        }
    }
    public void showOi() { System.out.println(oi); }
    void testInner() {
        Inner in = new Inner();
        in.modifyOuter();
    }
    public static void main(String[] args) {
        Outer7 out = new Outer7();
        out.showOi();
        out.testInner();
        out.showOi();
        Inner inner=out.new Inner();
        System.out.println(inner.s);
    }
}