package Exercise.section14.ex4;

import java.util.Arrays;
import java.util.List;

abstract class Shape {
	void draw() { System.out.println(this + ".draw()"); }
	abstract public String toString();
}

class Circle extends Shape {
	public String toString() { return "Circle"; }
}

class Square extends Shape {
	public String toString() { return "Square"; }
}

class Triangle extends Shape {
	public String toString() { return "Triangle"; }
}

class Rhomboid extends Shape {
	public String toString() { return "Rhomboid"; }
}

public class Shapes4 {
    public static void rotate(Shape shape) {
        if (!(shape instanceof Circle)) {
            System.out.println(shape+" rotate");
        }
    }
	public static void main(String[] args) {
		// upcasting to Shape:
		List<Shape> shapeList = Arrays.asList(
			new Circle(), new Square(), new Triangle(), new Rhomboid()
		);
		// downcasting back to specific shape:
		for(Shape shape : shapeList)
			shape.draw();
		Rhomboid r = new Rhomboid();
		((Shape)r).draw();
		// inconvertible types:
        Shape s=(Shape)r ;
		if (s instanceof Circle) {
            ((Circle)s).draw();
		}else {
            System.out.println("(Shape)r is not a Circle");
        }
        rotate(r);
		// ((Circle)r).draw();
	}
}