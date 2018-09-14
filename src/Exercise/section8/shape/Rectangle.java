package Exercise.section8.shape;

public class Rectangle extends Shape{
    @Override
    public void draw() {
        System.out.println("Rectangle.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Rectangle.erase()");
    }
    @Override
    public void print() {
        System.out.println("Rectangle.print");
    }
}
