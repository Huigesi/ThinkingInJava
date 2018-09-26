package Exercise.section18.ex15;

import java.io.*;

public class StoringAndRecoveringData15 {
    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("Data.txt")
                )
        );
        System.out.println("Initial out.size() = "+out.size());
        byte[] ba={0,1,2,3};
        out.write(ba, 0, 3);
        out.write(ba);
        out.write((int) 255);
        out.writeBoolean(true);
        out.writeByte((int)10000000);
        out.writeBytes((String) "hi");
        out.writeChar(120);
        out.writeChars("hi");
        out.writeDouble(3.14159);
        out.writeFloat(2.1f);
        out.writeInt(1057);
        out.writeLong(123456789L);
        out.writeShort(123);
        out.writeUTF("That was pi");
        System.out.println("After writing,out.size() = "+out.size());
        out.close();
        System.out.println("Reading");
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("Data.txt")
                )
        );
        byte[] baIn = new byte[3];
        System.out.println("bytes read by in.read(baIn,0,3) = " + in.read(baIn, 0, 3));
        System.out.println("baIn = ");
        for (int i = 0; i < baIn.length; i++) {
            System.out.println(baIn[i]+" ");
        }

        System.out.println("in.readInt()="+in.readInt());
        System.out.println("in.read()="+in.read());
        System.out.println("in.readBoolean()=" + in.readBoolean());
        System.out.println("in.readByte()= "+in.readByte());
        System.out.println("in.readDouble()= "+in.readDouble());
        System.out.println("in.readUTF()="+in.readUTF());
    }
}
