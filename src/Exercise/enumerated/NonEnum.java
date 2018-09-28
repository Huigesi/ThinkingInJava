package Exercise.enumerated;

public class NonEnum {
    public static void main(String[] args) {
        Class<Integer> intClass = Integer.class;
        for (Object en : intClass.getEnumConstants()) {
            System.out.println(en);
        }

    }
}
