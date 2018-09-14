package Exercise.section10.ex16;

interface Cycle {
    void ride();
}

interface CycleFactory {
    Cycle getCycle();
}

class Unicycle implements Cycle {
    public Unicycle() {
        System.out.println("Unicycle");
    }
    public void ride() { System.out.println("Ride Unicycle");}

    public static CycleFactory factory=new CycleFactory() {
        @Override
        public Cycle getCycle() {
            return new Unicycle();
        }
    };
}

class BicycleFactory implements CycleFactory {
    public BicycleFactory() {
        System.out.println("Bicycle");
    }

    public Cycle getCycle() {
        return new Cycle() {
            @Override
            public void ride() {
                System.out.println("Ride Bicycle");
            }
        };
    }
}

class TricycleFactory implements CycleFactory {
    public TricycleFactory() {
        System.out.println("Tricycle()");
    }

    public Cycle getCycle() {
        return new Cycle() {
            @Override
            public void ride() {
                System.out.println("Ride Tricycle");
            }
        };
    }
}

public class Cycles {
    public static void rideCycle(CycleFactory factory) {
        Cycle c = factory.getCycle();
        c.ride();
    }
    public static void main(String [] args) {
        rideCycle(Unicycle.factory);
        rideCycle(new BicycleFactory());
        rideCycle(new TricycleFactory());
    }
}
