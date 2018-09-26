package Exercise;

import java.util.Arrays;
import java.util.Collection;

public class PPrint {
    public static String pFormat(Collection<?> collection) {
        if (collection.size() == 0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        for (Object elem : collection) {
            if (collection.size() != 1) {
                builder.append("\n  ");
            }
            builder.append(elem);
        }
        if (collection.size() != 1) {
            builder.append("\n");
        }
        builder.append("]");
        return builder.toString();
    }
    public static void pPrint(Collection<?> c) {
        System.out.println(pFormat(c));
    }
    public static void pPrint(Object[] c){
        System.out.println(pFormat(Arrays.asList(c)));
    }
}
