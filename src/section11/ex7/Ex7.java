package section11.ex7;

import java.util.ArrayList;
import java.util.List;

public class Ex7 {
    public static void main(String[] args) {
        List<Bean> mList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Bean bean=new Bean();
            bean.setName("das"+i);
            mList.add(bean);
        }
        List<Bean> mListList = mList.subList(2,4);
        mList.removeAll(mListList);
        for (Bean bean : mList) {
            System.out.println(bean.name);
        }
    }
}
class Bean{
    String name;

    public void setName(String name) {
        this.name = name;
    }
}
