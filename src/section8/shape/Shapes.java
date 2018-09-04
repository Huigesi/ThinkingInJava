package section8.shape;

public class Shapes {
   private static RandomShapeGenerator gen=new RandomShapeGenerator();

    public static void main(String[] args) {
        Shape[] shapes = new Shape[10];
        for (int i = 0; i < shapes.length; i++) {
            shapes[i]=gen.next();
        }
        for (Shape shape:shapes){
            shape.draw();
            shape.print();
        }
    }
}
