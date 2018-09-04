package section7;

public class Exercise3 extends bb{

    public static void main(String[] args) {
        Exercise3 exercise3=new Exercise3();
    }
}
class aa{
    public aa() {
        System.out.println("aa()");
    }
}

class bb extends aa{
    public bb() {
        System.out.println("bb()");
    }
}
