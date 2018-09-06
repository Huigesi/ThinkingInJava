package section14.ex8;

class A {
}

class B extends A {
}

class C extends B {
}

public class Ex8 {
    public static void printt(Object o) {
        if (o.getClass().getSuperclass() != null) {

            System.out.println(o.getClass() + " is a subclass of " + o.getClass().getSuperclass());

            try {
                printt(o.getClass().getSuperclass().newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        printt(new C());
    }
}
