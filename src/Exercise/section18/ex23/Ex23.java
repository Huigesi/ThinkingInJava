package Exercise.section18.ex23;

import java.nio.CharBuffer;

public class Ex23 {
    public static boolean isPrintable(char c) {
        return ((c >= '!') && (c <= '~')) ? true : false;
    }

    public static void printCharBuffer(CharBuffer charBuffer) {
        charBuffer.clear();
        while (charBuffer.hasRemaining()) {
            char c = charBuffer.get();
            if (isPrintable(c)) {
                System.out.print(c);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        char[] ca = {'w', 'x', 'y', 'z'};
        CharBuffer cb = CharBuffer.wrap(ca);
        System.out.println("CharBuffer by wrapping char[]: ");
        printCharBuffer(cb);
        System.out.println();
        CharBuffer cb2 = CharBuffer.allocate(6);
        char[] ca2 = {'s', 't', 'u', 'v', 'w'};
        cb2.put(ca2);
        System.out.print("CharBuffer by allocation: ");
        printCharBuffer(cb2);
        System.out.println();
        char[] ca3 = {(char) 0x01, (char) 0x07, (char) 0.7f, 'b', 'y', 'e'};
        CharBuffer cb3 = CharBuffer.wrap(ca3);
        System.out.print("CharBuffer including some unprintables: ");
        printCharBuffer(cb3);

    }
}
