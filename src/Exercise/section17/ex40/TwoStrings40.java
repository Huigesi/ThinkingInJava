package Exercise.section17.ex40;

import Exercise.RandomGenerator;

import java.util.*;


public class TwoStrings40 implements Comparable<TwoStrings40>{
    private String first = "";
    private String second = "";

    public TwoStrings40(String first, String second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(TwoStrings40 o) {
        System.out.println("first.compareTo(o.first):"+first.compareTo(o.first));
        return first.compareTo(o.first);
    }
    public String toString() {
        return first + " & " + second;
    }

    static void printArray(TwoStrings40[] sa) {
        System.out.print("(");
        for(int i = 0; i < sa.length - 1; i++)
            System.out.print(sa[i] + " , ");
        System.out.print(sa[sa.length - 1] + ")\n");
    }

    public static class Comp2 implements Comparator<TwoStrings40> {

        @Override
        public int compare(TwoStrings40 o1, TwoStrings40 o2) {
            return o1.second.compareTo(o2.second);
        }
    }

    public static void main(String[] args) {
        RandomGenerator.String rgs = new RandomGenerator.String(4);
        TwoStrings40[] array = new TwoStrings40[5];
        List<TwoStrings40> list = new ArrayList<TwoStrings40>();
        for(int i = 0; i < array.length; i++) {
            String s1 = rgs.next();
            String s2 = rgs.next();
            array[i] = new TwoStrings40(s1, s2);
            list.add(new TwoStrings40(s1, s2));
        }
        System.out.print("Array:" );
        printArray(array);
        Arrays.sort(array);
        Collections.sort(list, null);
        System.out.print("Sorted by first word:");
        System.out.print("Array: ");
        printArray(array);

        TwoStrings40.Comp2 comp = new TwoStrings40.Comp2();
        Arrays.sort(array, comp);
        Collections.sort(list, comp);
        System.out.print("Sorted by second word:");
        System.out.print("Array: ");
        printArray(array);
        System.out.print("List: " + list);

    }
}
