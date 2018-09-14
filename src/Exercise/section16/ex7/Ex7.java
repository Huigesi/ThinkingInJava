package Exercise.section16.ex7;

import Exercise.section16.BerylliumSphere;
import Exercise.section16.ex6.Ex6;

import java.util.Arrays;

public class Ex7 {
    public BerylliumSphere[][][] createBery(int size1,int size2,int size3) {
        BerylliumSphere[][][] berylliumSpheres=new BerylliumSphere[size1][size2][size3];
        for (int i = 0; i < size1; i++) {
            berylliumSpheres[i] = new Ex6().createBery(size2, size3);
        }
       return berylliumSpheres;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Ex7().createBery(3,4,2)));
    }
}
