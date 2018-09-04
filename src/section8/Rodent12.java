package section8;


import section8.Rodent14.RandomRodentGenerator;

class Characteristic {
    private String s;
    Characteristic(String s) {
        this.s = s;
        System.out.println("Creating Characteristic " + s);
    }
}

class Description {
    private String s;
    Description(String s) {
        this.s = s;
        System.out.println("Creating Description " + s);
    }
}

class Rodent {
    private String name = "Rodent";
    private Characteristic c = new Characteristic("has tail");
    private Description d = new Description("small mammal");
    Rodent() { System.out.println("Rodent()"); }
    protected void eat() { System.out.println("Rodent.eat()"); }
    protected void run() { System.out.println("Rodent.run()"); }
    protected void sleep() { System.out.println("Rodent.sleep()"); }
    public String toString() { return name; }
}

class Mouse extends Rodent {
    private String name = "Mouse";
    private Characteristic c = new Characteristic("likes cheese");
    private Description d = new Description("nocturnal");
    Mouse() { System.out.println("Mouse()"); }
    protected void eat() { System.out.println("Mouse.eat()"); }
    protected void run() { System.out.println("Mouse.run()"); }
    protected void sleep() { System.out.println("Mouse.sleep()"); }
    public String toString() { return name; }
}

class Rat extends Rodent {
    private String name = "Rat";
    private Characteristic c = new Characteristic("larger");
    private Description d = new Description("black");
    Rat() { System.out.println("Rat()"); }
    protected void eat() { System.out.println("Rat.eat()"); }
    protected void run() { System.out.println("Rat.run()"); }
    protected void sleep() { System.out.println("Rat.sleep()"); }
    public String toString() { return name; }
}

class Squirrel extends Rodent {
    private String name = "Squirrel";
    private Characteristic c = new Characteristic("climbs trees");
    private Description d = new Description("likes nuts");
    Squirrel() { System.out.println("Squirrel()"); }
    protected void eat() { System.out.println("Squirrel.eat()"); }
    protected void run() { System.out.println("Squirrel.run()"); }
    protected void sleep() { System.out.println("Squirrel.sleep()"); }
    public String toString() { return name; }
}

public class Rodent12 {
    /*private static RandomRodentGenerator gen = new RandomRodentGenerator();
    public static void main(String[] args) {
        Rodent[] rodents = new Rodent[10];
        for(Rodent r : rodents) {
            r = gen.next();
            System.out.println(r);
        }
    }*/
}