package Exercise.section18.ex24;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.IntBuffer;

public class DoubleBufferDemo {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        DoubleBuffer ib = bb.asDoubleBuffer();
        ib.put(new double[]{11.12, 42.1, 47.1, 99.1, 143.1, 811.1, 1016.2});
        System.out.println(ib.get(3));
        System.out.println();
        ib.put(3, 1811);
        ib.flip();
        while (ib.hasRemaining()) {
            double i = ib.get();
            System.out.println(i);
        }
    }
}
