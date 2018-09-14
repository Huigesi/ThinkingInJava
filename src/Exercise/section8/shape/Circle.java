package Exercise.section8.shape;

public class Circle extends Shape{
    @Override
    public void draw() {
        System.out.println("Circle.draw()");
    }
    @Override
    public void erase() {
        System.out.println("Circle.erase()");
    }

    @Override
    public void print() {
        System.out.println("Circle.print");
    }
}
