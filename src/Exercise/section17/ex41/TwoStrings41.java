package Exercise.section17.ex41;

import Exercise.RandomGenerator;

import java.util.*;


public class TwoStrings41 implements Comparable<TwoStrings41>{
    public String first = "";
    public String second = "";

    public TwoStrings41(String first, String second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(TwoStrings41 o) {
        System.out.println("first.compareTo(o.first):"+first.compareTo(o.first));
        return first.compareTo(o.first);
    }
    public String toString() {
        return first + " & " + second;
    }

    static void printArray(TwoStrings41[] sa) {
        System.out.print("(");
        for(int i = 0; i < sa.length - 1; i++)
            System.out.print(sa[i] + " , ");
        System.out.print(sa[sa.length - 1] + ")\n");
    }

    public static class Comp2 implements Comparator<TwoStrings41> {

        @Override
        public int compare(TwoStrings41 o1, TwoStrings41 o2) {
            return o1.second.compareTo(o2.second);
        }
    }

    public static void main(String[] args) {
        RandomGenerator.String rgs = new RandomGenerator.String(4);
        RandomGenerator.Integer rgi=new RandomGenerator.Integer(100);
        //TwoStrings41[] array = new TwoStrings41[5];
        Set<TwoStrings41> set = new HashSet<>();
        Map<TwoStrings41, Integer> map = new HashMap<>();

        for(int i = 0; i < 4; i++) {
            String s1 = rgs.next();
            String s2 = rgs.next();
            set.add(new TwoStrings41(s1, s2));
            map.put(new TwoStrings41(s1, s2), rgi.next());
        }
        System.out.println("Set:"+set);
        System.out.println("Map:"+map);
        Set<TwoStrings41> sortSet = new TreeSet<>(set);
        Map<TwoStrings41, Integer> sortMap = new TreeMap<>(map);
                System.out.println("Sorted by first word:");
        System.out.println("Set:"+sortSet);
        System.out.println("Map:"+sortMap);


        TwoStrings41.Comp2 comp = new TwoStrings41.Comp2();
        Set<TwoStrings41> sortSet2 = new TreeSet<>(comp);
        Map<TwoStrings41, Integer> sortMap2 = new TreeMap<>(comp);
        sortSet2.addAll(sortSet);
        sortMap2.putAll(sortMap);
        System.out.println("Set2:"+sortSet2);
        System.out.println("Map2:"+sortMap2);
    }
}
