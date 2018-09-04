package section10.ex11;

class Test {
    private class Inner implements Ex11Interface {
        public void say(String s) {
            System.out.println(s);
        }
    }
    Ex11Interface f() {
        return new Inner();
    }
}
public class Ex11 {
    public static void main(String[] args) {
        Test t = new Test();
        t.f().say("hi");
        // Error: cannot find symbol: class Inner:
        // ((Inner)t.f()).say("hello");
    }
}