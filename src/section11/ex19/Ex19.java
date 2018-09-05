package section11.ex19;

import java.util.*;

public class Ex19 {
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
        //HashSet
        Set<String> set1 = new HashSet<>(map.keySet());
        System.out.println(set1);
        Map<String, String> linkMap1 = new LinkedHashMap<>();
        for (String e : set1) {
            System.out.println("Adding "+e+",");
            linkMap1.put(e, map.get(e));
        }
        System.out.println(linkMap1);
        //LinkedHashSet
        Set<String> set2 = new LinkedHashSet<>(map.keySet());
        System.out.println(set1);
        Map<String, String> linkMap2 = new LinkedHashMap<>();
        for (String e : set2) {
            System.out.println("Adding "+e+",");
            linkMap2.put(e, map.get(e));
        }
        System.out.println(linkMap2);
    }
}
