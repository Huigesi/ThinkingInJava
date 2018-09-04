package section10.ex6.pg3;

import section10.ex6.pg1.Inter1;
import section10.ex6.pg2.Class2;

public class Class3 extends Class2 {
    Inter1 getInner() {
        return this.new Class2_1();
    }
    public static void main(String[] args) {
        Class3 class3=new Class3();
        System.out.println(class3.getInner().in1());
    }
}
