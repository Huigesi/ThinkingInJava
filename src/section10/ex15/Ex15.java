package section10.ex15;

class NeedP{
    public NeedP(int i) {
        System.out.println("i:"+i);
    }
}
class NeedP2{
    NeedP getNeedP() {
        return new NeedP(1){
        };
    }
}
public class Ex15 {
    public static void main(String[] args) {
        NeedP2 needP2=new NeedP2();
        needP2.getNeedP();
    }
}
