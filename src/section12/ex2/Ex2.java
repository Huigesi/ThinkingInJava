package section12.ex2;

public class Ex2 {
    public static void main(String[] args) {
        Integer i=null;
        try {
            System.out.println(i.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
