package Exercise.section15.ex3;

class SixTuple<A,B,C,D,E,F>{
    public final A one;
    public final B two;
    public final C three;
    public final D four;
    public final E five;
    public final F six;

    public SixTuple(A one, B two, C three, D four, E five, F six) {
        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;
        this.five = five;
        this.six = six;
    }

    public String toString() {
        return one+" "+two+" "+three+" "+four+" "+five+" "+six+"";
    }
}
public class Ex3 {
    static SixTuple<String,String,String,String,String,Integer> g(){
        return new SixTuple<String,String,String,String,String,Integer>
                ("a","b","c","d","e",Integer.valueOf(10));
    }

    public static void main(String[] args) {
        SixTuple<String,String,String,String,String,Integer> six=g();
        System.out.println(six);
        System.out.println(g());
    }
}
