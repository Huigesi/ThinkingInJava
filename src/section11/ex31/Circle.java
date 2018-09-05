package section11.ex31;

public class Circle extends Shape {
   @Override public void draw() { System.out.println("Circle.draw()"); }
   @Override public void erase() { System.out.println("Circle.erase()"); }
   @Override public void amend() { System.out.println("Circle.amend()"); }
   @Override public String toString() { return "Circle"; }
}
