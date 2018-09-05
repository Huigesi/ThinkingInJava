package section11.ex14;

import java.util.LinkedList;
import java.util.ListIterator;

public class Ex14 {
    static void add(LinkedList<Integer> list, Integer[] x) {

        for (Integer i : x) {
            ListIterator<Integer> iterator = list.listIterator((list.size())/2);
            iterator.add(i);
            System.out.println(list);
        }

    }
    public static void main(String[] args) {
        LinkedList<Integer> mList = new LinkedList<>();
        Integer[] x = {11, 21, 33, 4, 5, 6};
        Ex14.add(mList,x);

    }
}
