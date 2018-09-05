package section12.ex6;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class Exception1 extends Exception {
    private static Logger logger = Logger.getLogger("LoggingException");

    public Exception1() {
        StringWriter stringWriter = new StringWriter();
        printStackTrace(new PrintWriter(stringWriter));
        logger.severe(stringWriter.toString());
    }
}
class Exception2 extends Exception {
    private static Logger logger = Logger.getLogger("LoggingException");

    public Exception2() {
        StringWriter stringWriter = new StringWriter();
        printStackTrace(new PrintWriter(stringWriter));
        logger.severe(stringWriter.toString());
    }
}
public class Ex6 {
    public static void f() throws Exception1,Exception2{
        throw new Exception1();
    }
    public static void g() throws Exception2{
        throw new Exception2();
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (Exception1 exception1) {
            exception1.printStackTrace();
        } catch (Exception2 exception2) {
            exception2.printStackTrace();
        }
        try {
            g();
        } catch (Exception2 exception2) {
            exception2.printStackTrace();
        }
    }
}
