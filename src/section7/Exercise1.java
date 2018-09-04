package section7;

public class Exercise1 {
    private String s1,s2,s3;
    private Ex2 e4;

    public Exercise1() {
        this.s1 = "str1";
        this.s2 = "str2";
        this.s3 = "str3";
    }

    public String toString() {
        if (e4 == null) {
            e4=new Ex2();
        }
        return "s1="+s1+"\n"+
                "s2="+s2+"\n"+
                "s3="+s3+"\n"+
                "s4"+e4;
    }

    public static void main(String[] args) {
        Exercise1 exercise1=new Exercise1();
        System.out.println(exercise1);
    }
}
class Ex2{
    private String s;
    public Ex2() {
        System.out.println("ex2()");
        this.s = "constructed";
    }

    public String toString() {
        return s;
    }
}
