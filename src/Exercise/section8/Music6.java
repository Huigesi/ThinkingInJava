package Exercise.section8;

import java.util.Random;

class Instrument {
    void play(Note n) {
        System.out.println("Instrument.play() " + n); }
    public String toString() { return "Instrument"; }
    void adjust() { System.out.println("Adjusting Instrument"); }
}

class Sks extends Instrument{
    void play(Note n) { System.out.println("Sks.play() " + n); }
    public String toString() { return "Sks"; }
    void adjust() { System.out.println("Adjusting Sks"); }
}

class Wind extends Instrument {
    void play(Note n) { System.out.println("Wind.play() " + n); }
    public String toString() { return "Wind"; }
    void adjust() { System.out.println("Adjusting Wind"); }
}

class Percussion extends Instrument {
    void play(Note n) { System.out.println("Percussion.play() " + n); }
    public String toString() { return "Percussion"; }
    void adjust() { System.out.println("Adjusting Percussion"); }
}

class Stringed extends Instrument {
    void play(Note n) { System.out.println("Stringed.play() " + n); }
    public String toString() { return "Stringed"; }
    void adjust() { System.out.println("Adjusting Stringed"); }
}

class Brass extends Wind {
    void play(Note n) { System.out.println("Brass.play() " + n); }
    public String toString() { return "Brass"; }
    void adjust() { System.out.println("Adjusting Brass"); }
}

class Woodwind extends Wind {
    void play(Note n) { System.out.println("Woodwind.play() " + n); }
    public String toString() { return "Woodwind"; }
}

public class Music6 {
    // Doesn't care about type, so new types
    // added to the system still work right:
    public static void tune(Instrument i) {
        //...
        i.play(Note.MIDDLE_C);
    }
    public static void tuneAll(Instrument[] e) {
        for(Instrument i : e)
            tune(i);
    }
    private static Random random = new Random();
    public static Instrument InstrumentNext() {
        switch (random.nextInt(6)) {
            default:
            case 0:return new Wind();
            case 1:return new Percussion();
            case 2:return new Stringed();
            case 3:return new Brass();
            case 4:return new Woodwind();
            case 5:return new Sks();
        }
    }
    public static void main(String[] args) {
        // Upcasting during addition to the array:
        Instrument[] Instruments = new Instrument[10];
        for (int i = 0; i < Instruments.length; i++) {
            Instruments[i]=InstrumentNext();
        }
        for (Instrument instrument:Instruments){
            System.out.println(instrument);
        }
    }
}