package section11.ex24;

import java.util.*;

public class Ex24 {
    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<>();
        Bean bean = new Bean();
        map.put("1", 2);
        map.put("9", 1);
        map.put("3", 4);
        map.put("6", 2);
        map.put("5", 1);
        System.out.println(map);
        SortedSet<String> key = new TreeSet<>(map.keySet());
        System.out.println(key);
        Iterator<String> iterator = key.iterator();
        while (iterator.hasNext()) {
            String s=(String) iterator.next();
            Integer i = map.get(s);
            map.remove(s);
            map.put(s, i);
        }
        System.out.println(map);
    }
}
class Bean{
    String name;

    public void setName(String name) {
        this.name = name;
    }
}
