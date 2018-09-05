package section11.ex29;

import java.util.PriorityQueue;

public class Ex29 {
    public static void main(String[] args) {
        PriorityQueue<Simple> s = new PriorityQueue<Simple>();
        // OK to add one Simple:
        s.offer(new Simple());
        // but no more allowed; get runtime exception:
        // Simple cannot be cast to Comparable:
        s.offer(new Simple());
    }
}
class Simple extends Object {}
