package section16.ex20;

import java.util.Arrays;

public class Ex20 {
    public static void main(String[] args) {
        int[][][] a1 = new int[4][3][2];
        int[][][] a2 = new int[4][3][2];
        System.out.println(Arrays.deepToString(a1));
        System.out.println(Arrays.deepEquals(a1,a2));
    }
}
