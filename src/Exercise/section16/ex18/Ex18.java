package Exercise.section16.ex18;

import Exercise.section16.BerylliumSphere;

import java.util.Arrays;

public class Ex18 {
    public static void main(String[] args) {
        BerylliumSphere[] berylliumSpheres = new BerylliumSphere[3];
        BerylliumSphere[] berylliumSpheres2 = new BerylliumSphere[4];
        Arrays.fill(berylliumSpheres,new BerylliumSphere());
        Arrays.fill(berylliumSpheres2,new BerylliumSphere());
        System.out.println("berylliumSpheres : "+Arrays.toString(berylliumSpheres));
        System.out.println("berylliumSpheres2 : "+Arrays.toString(berylliumSpheres2));
        System.arraycopy(berylliumSpheres,0,berylliumSpheres2,0,berylliumSpheres.length);
        System.out.println("berylliumSpheres2 : "+Arrays.toString(berylliumSpheres2));
    }
}
