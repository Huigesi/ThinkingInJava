package Exercise.section16.ex6;

import Exercise.section16.BerylliumSphere;

import java.util.Arrays;

public class Ex6 {
    public BerylliumSphere[][] createBery(int size1,int size2) {
        BerylliumSphere[][] berylliumSpheres=new BerylliumSphere[size1][size2];
        for (int i = 0; i < size1; i++) {
            berylliumSpheres[i] = new BerylliumSphere[size2];
            for (int j = 0; j < size2; j++) {
                berylliumSpheres[i][j] = new BerylliumSphere();
            }
        }
       return berylliumSpheres;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Ex6().createBery(3,4)));
    }
}
