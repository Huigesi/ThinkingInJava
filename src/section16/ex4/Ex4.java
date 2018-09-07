package section16.ex4;

import section16.ex3.Ex3;

import java.util.Arrays;

public class Ex4 {
    public static double[][][] multiDimArray(int size1, int size2, int size3,double start, double end) {
        if (!(start < end)) {
            return null;
        }
        if (size1 < 1 || size2 < 1||size3<1) {
            return null;
        }
        double[][][] doubles = new double[size1][size2][size3];
        for (int j = 0; j < size3; j++) {
            doubles[0][0][j] = (start + ((double) j / (size3 - 1)) * (end - start));
        }
        if (size1 == 1) {
            return doubles;
        }else {
            for (int i = 1; i < size1; i++) {
                doubles[i] = Ex3.multiDimArray(size2, size3, start, end);
            }
            return doubles;
        }
    }

    public static void printArray(double[][][] doubles) {
        System.out.println(Arrays.deepToString(doubles));
    }

    public static void main(String[] args) {
        printArray(multiDimArray(2, 2, 3,1, 2));
        printArray(multiDimArray(2, 3, 3,3, 4));
        printArray(multiDimArray(1,2,3,5,10));
    }
}
