package Exercise.section8;

class Cycle {
    private String name = "Cycle";
    private int i=0;
    public void travel(Cycle c){
        System.out.println("Cycle.ride()"+c);
    }
    public int wheels() {
        return i;
    }

    public String toString() {
        return this.name;
    }
}
class Unicycle extends Cycle{
    private String name = "Unicycle";
    private int i=1;

    @Override
    public int wheels() {
        return i;
    }

    public String toString() {
        return this.name;
    }
}
class Bicycle extends Cycle{
    private String name = "Bicycle";
    private int i=2;

    @Override
    public int wheels() {
        return i;
    }

    public String toString() {
        return this.name;
    }
}
class Tricycle extends Cycle{
    private String name = "Tricycle";
    private int i=3;

    @Override
    public int wheels() {
        return i;
    }

    public String toString() {
        return this.name;
    }
}
public class Exercise1{
    public static void ride(Cycle cycle) {
        cycle.travel(cycle);
        System.out.println(cycle.wheels());
    }

    public static void main(String[] args) {
        Unicycle unicycle=new Unicycle();
        Bicycle bicycle=new Bicycle();
        Tricycle tricycle = new Tricycle();
        ride(unicycle);
        ride(bicycle);
        ride(tricycle);
    }
}