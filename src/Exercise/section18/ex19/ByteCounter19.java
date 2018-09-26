package Exercise.section18.ex19;

import Exercise.TextFile;

import java.io.IOException;
import java.util.*;

import static Exercise.BinaryFile.read;

public class ByteCounter19 {

    public static void main(String[] args) {
        String fileName = "ByteCounter19.java";
        try {
            byte[] ba = read(fileName);
            Set<Byte> byteSet = new TreeSet<>();
            for (byte b : ba) {
                byteSet.add(b);
            }
            List<Byte> byteList = new ArrayList<>();
            for (byte b : ba) {
                byteList.add(b);
            }
            Map<Byte, Integer> byteMap = new HashMap<>();
            for (Byte b : byteSet) {
                int count = 0;
                for (Byte d : byteList) {
                    if (d.equals(b)) count++;
                }
                byteMap.put(b, count);
            }
            System.out.println();
            System.out.println(byteMap);
        } catch (IOException e) {
            System.err.println("Caught " + e);
        }
    }
}
