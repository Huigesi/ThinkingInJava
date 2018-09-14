package Exercise.section16.ex3;

import java.util.Arrays;

public class Ex3 {
    public static double[][] multiDimArray(int size1, int size2, double start, double end) {
        if (!(start < end)) {
            return null;
        }
        if (size1 < 1 || size2 < 1) {
            return null;
        }
        double[][] doubles = new double[size1][size2];
        for (int j = 0; j < size2; j++) {
            doubles[0][j] = (start + ((double) j / (size2 - 1)) * (end - start));
        }
        if (size1 == 1) {
            return doubles;
        }else {
            for (int i = 1; i < size1; i++) {
                doubles[i] = new double[size2];
                for (int j = 1; j < size2; j++) {
                    doubles[i][j]=start+((double)j/(size2-1))*(((double)j-(double)i)/(size2-1-i))*(end-start);
                }
            }
            return doubles;
        }
    }

    public static void printArray(double[][] doubles) {
        System.out.println(Arrays.deepToString(doubles));
    }

    public static void main(String[] args) {
        printArray(multiDimArray(2, 2, 1, 2));
        printArray(multiDimArray(2, 3, 5, 4));
        printArray(multiDimArray(1,2,5,10));
    }
}
