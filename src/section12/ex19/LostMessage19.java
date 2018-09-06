package section12.ex19;

class VeryImportantException extends Exception {
    public String toString() {
        return "A very important exception!";
    }
}

class HoHumException extends Exception {
    public String toString() {
        return "A trivial exception";
    }
}

class MeaninglessException extends Exception {
    public String toString() {
        return "A meaningless exception";
    }
}

public class LostMessage19 {
    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }

    void dispose() throws HoHumException {
        throw new HoHumException();
    }

    void eliminate() throws MeaninglessException {
        throw new MeaninglessException();
    }

    public static void main(String[] args) {
        try {
            LostMessage19 lm = new LostMessage19();
            try {
                lm.f();
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                lm.dispose();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}