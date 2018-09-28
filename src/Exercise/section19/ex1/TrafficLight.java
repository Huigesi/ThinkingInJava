package Exercise.section19.ex1;

import static Exercise.section19.ex1.Signal.GREEN;
import static Exercise.section19.ex1.Signal.RED;
import static Exercise.section19.ex1.Signal.YELLOW;

enum Signal{GREEN,YELLOW,RED}

public class TrafficLight {
    Signal color= RED;

    public void change() {
        switch (color) {
            case RED: color= GREEN;
            break;
            case GREEN: color= YELLOW;
            break;
            case YELLOW: color= RED;
            break;
        }
    }

    @Override
    public String toString() {
        return "The traffic light is "+color;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight();
        for (int i = 0; i < 7; i++) {
            System.out.println(t);
            t.change();
        }
    }
}