package section16.ex19;

import java.util.Arrays;

public class Ex19 {
    protected int i;

    public Ex19(int i) {
        this.i = i;
    }

    public boolean equals(Object o) {
        return (o.getClass().getSimpleName() .equals("Ex19")  && this.i == ((Ex19) o).i) ? true : false;
    }

    public static void main(String[] args) {
        Ex19[] mEx19s = {new Ex19(1),new Ex19(2),new Ex19(3)};
        Ex19[] mEx192s ={new Ex19(1),new Ex19(2),new Ex19(3)};
        System.out.println(Arrays.toString(mEx19s));
        System.out.println(Arrays.toString(mEx192s));
        System.out.println(Arrays.equals(mEx19s,mEx192s));
    }
}
