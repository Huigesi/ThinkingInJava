package Exercise.section14.ex8;

class A {
}

class B extends A {
}

class C extends B {
}

public class Ex8 {
    public static void printt(Object o) {
        Object[] fields = o.getClass().getDeclaredFields();
        if(fields.length == 0)
            System.out.println(o.getClass() + " has no fields");
        if(fields.length > 0) {
            System.out.println("Field(s) of " + o.getClass() + ":");
            for(Object obj : fields)
                System.out.println(" " + obj);
        }
        if (o.getClass().getSuperclass() != null) {

            System.out.println(o.getClass() + " is a subclass of " + o.getClass().getSuperclass()
                    + " DeclaredFields: "+o.getClass().getDeclaredFields());

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
