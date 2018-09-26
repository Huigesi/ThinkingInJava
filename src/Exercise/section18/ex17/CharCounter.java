package Exercise.section18.ex17;

import Exercise.TextFile;

import java.util.*;

public class CharCounter {
    public static void main(String[] args) {
        String fileName = "CharCounter.java";
        char[] ca= TextFile.read(fileName).toCharArray();
        Set<Character> charSet = new TreeSet<>();
        for (char c : ca) {
            charSet.add(c);
        }
        List<Character> characters = new ArrayList<>();
        for (char c : ca) {
            characters.add(c);
        }
        Map<Character, Integer> charMap = new HashMap<>();
        for (Character c : charSet) {
            int count=0;
            for (Character d : characters) {
                if (d.equals(c)){
                    count++;
                }
            }
            charMap.put(c, count);
        }
        System.out.println();
        System.out.println(charMap);
    }
}
