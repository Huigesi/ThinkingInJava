package section16.ex2;

import section16.BerylliumSphere;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex2 {
    public static BerylliumSphere[] getBery(int size) {
        BerylliumSphere berylliumSphere = new BerylliumSphere();
        BerylliumSphere[] berylliumSpheres = new BerylliumSphere[size];
        for (int i = 0; i < size; i++) {
            berylliumSpheres[i] = berylliumSphere;
        }
        return berylliumSpheres;
    }
    public static BerylliumSphere[] someSpheres(int n) {
        BerylliumSphere[] result = new BerylliumSphere[n];
        for(int i = 0; i < n; i++)
            result[i] = new BerylliumSphere();
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getBery(3));
        System.out.println(Arrays.asList(someSpheres(3)));
    }
}
