package Exercise.section17.ex42;

import Exercise.RandomGenerator;

import java.util.*;


public class TwoStrings42 implements Comparable<TwoStrings42>{
    private String first = "";
    private String second = "";

    public TwoStrings42(String first, String second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(TwoStrings42 o) {
        System.out.println("first.compareTo(o.first):"+first.compareTo(o.first));
        return first.compareToIgnoreCase(o.first);
    }
    public String toString() {
        return first + " & " + second;
    }

    static void printArray(TwoStrings42[] sa) {
        System.out.print("(");
        for(int i = 0; i < sa.length - 1; i++)
            System.out.print(sa[i] + " , ");
        System.out.print(sa[sa.length - 1] + ")\n");
    }

    public static class Comp2 implements Comparator<TwoStrings42> {

        @Override
        public int compare(TwoStrings42 o1, TwoStrings42 o2) {
            return o1.second.compareToIgnoreCase(o2.second);
        }
    }

    public static void main(String[] args) {
        RandomGenerator.String rgs = new RandomGenerator.String(4);
        TwoStrings42[] array = new TwoStrings42[5];
        List<TwoStrings42> list = new ArrayList<TwoStrings42>();
        for(int i = 0; i < array.length; i++) {
            String s1 = rgs.next();
            String s2 = rgs.next();
            array[i] = new TwoStrings42(s1, s2);
            list.add(new TwoStrings42(s1, s2));
        }
        System.out.print("Array:" );
        printArray(array);
        Arrays.sort(array);
        Collections.sort(list, null);
        System.out.print("Sorted by first word:");
        System.out.print("Array: ");
        printArray(array);

        TwoStrings42.Comp2 comp = new TwoStrings42.Comp2();
        Arrays.sort(array, comp);
        Collections.sort(list, comp);
        System.out.print("Sorted by second word:");
        System.out.print("Array: ");
        printArray(array);
        System.out.print("List: " + list);

    }
}
