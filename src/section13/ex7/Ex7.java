package section13.ex7;

public class Ex7 {
    public static void main(String[] args) {
        String reg="^[A-Z].*[\\\\.]$";
        System.out.println("Adas.".matches(reg));
        System.out.println("adas.".matches(reg));
    }
}
