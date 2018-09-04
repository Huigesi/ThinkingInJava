package section10.ex13;

import section10.ex9.Inner;

public class Ex13 {
    Inner ex9void() {
        return new Inner(){

            @Override
            public void say() {
                System.out.println("hi");
            }
        };
    }
    public static void main(String[] args) {
        Ex13 ex9 = new Ex13();
        ex9.ex9void().say();
    }
}
