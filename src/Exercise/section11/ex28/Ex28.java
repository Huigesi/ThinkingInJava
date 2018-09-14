package Exercise.section11.ex28;

import java.util.PriorityQueue;
import java.util.Random;

public class Ex28 {
    public static void main(String[] args) {
        Random random = new Random();
        PriorityQueue<Double> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < 10; i++) {
            priorityQueue.offer(random.nextDouble());
        }
        System.out.println(priorityQueue);
        System.out.println(priorityQueue.poll());
    }
}
