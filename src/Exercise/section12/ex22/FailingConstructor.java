package Exercise.section12.ex22;

public class FailingConstructor {
    Integer[] i = new Integer[2];
    public FailingConstructor() throws Exception{
        i[0]=1;
        i[1]=1;
        i[2]=1;
    }

    public void dispose() {

    }

    public static void main(String[] args) {
        try {
            FailingConstructor failingConstructor=new FailingConstructor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
