package section12.ex21;

public class Ex21 {
    public static void main(String[] args) {
        try {
            Dog dog=new Dog();
        } catch (Exception1 exception1) {
            exception1.printStackTrace();
        }
    }
}
class Base {
    public Base() throws Exception1{
        throw new Exception1();
    }
}
class Dog extends Base{

    public Dog() throws Exception1 {
            super();
    }
}

class Exception1 extends Exception {
}
