package section10.ex9;

public class Ex9 {
    Inner ex9void() {
        class Ex9_1 implements Inner {

            @Override
            public void say() {
                System.out.println("hi");
            }
        }
        return new Ex9_1();
    }
    public static void main(String[] args) {
        Ex9 ex9 = new Ex9();
        ex9.ex9void().say();
    }
}
