package section16.ex6;

import section16.BerylliumSphere;

import java.util.Arrays;

public class Ex6 {
    public void createBery(int size1,int size2) {
        BerylliumSphere[][] berylliumSpheres=new BerylliumSphere[size1][size2];
        for (int i = 0; i < size1; i++) {
            berylliumSpheres[i] = new BerylliumSphere[size2];
            for (int j = 0; j < size2; j++) {
                berylliumSpheres[i][j] = new BerylliumSphere();
            }
        }
        System.out.println(Arrays.deepToString(berylliumSpheres));
    }

    public static void main(String[] args) {
        new Ex6().createBery(2,3);
    }
}
