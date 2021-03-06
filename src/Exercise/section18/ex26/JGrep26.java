package Exercise.section18.ex26;

import java.io.File;
import java.io.FileInputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JGrep26 {
    public static void main(String[] args) throws Exception{
        if (args.length < 2) {
            System.out.println("Usage: java JGrep26 file regex");
            System.exit(0);
        }
        FileChannel fc = new FileInputStream(args[0]).getChannel();
        MappedByteBuffer in = fc.map(FileChannel.MapMode.READ_ONLY, 0,
                new File(args[0]).length());
        String[] sa = Charset.forName(System.getProperty("file.encoding"))
                .decode(in).toString().split("\n");
        Pattern p = Pattern.compile(args[1]);
        Matcher m = p.matcher("");
        int index=0;
        for (String line : sa) {
            m.reset(line);
            while (m.find()) {
                System.out.println(index++ + ": " + m.group() + ": " + m.start());
            }
        }
        fc.close();
    }
}
