package Exercise.section11.ex12;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Ex12 {
    public static void main(String[] args) {
        List<Integer> mList1 = new ArrayList<>();

        List<Integer> mList2 = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            mList1.add(i);
            mList2.add(i + 1);
        }
        ListIterator<Integer> it1=mList1.listIterator(mList1.size());
        ListIterator<Integer> it2=mList2.listIterator();
        while (it2.hasNext()) {
            System.out.println(it2.next()+" ");
            it2.set(it1.previous());
        }
        System.out.println(mList1);
        System.out.println(mList2);
    }
}
