package Exercise.section11.ex18;

import java.util.*;

public class Ex18 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "1");
        map.put("c", "3");
        map.put("b", "2");
        map.put("d", "4");
        System.out.println(map);
        Set<String> set = new TreeSet<>(map.keySet());
        System.out.println(set);
        Map<String, String> linkMap = new LinkedHashMap<>();
        for (String e : set) {
            System.out.println("Adding "+e+",");
            linkMap.put(e, map.get(e));
        }
        System.out.println(linkMap);
    }
}
