package Exercise.section18.ex5;

import Exercise.Directory;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

public class ProcessFiles {
    public interface Strategy{
        void process(File file);
    }

    private Strategy mStrategy;
    private String ext;

    public ProcessFiles(Strategy strategy, String ext) {
        mStrategy = strategy;
        this.ext = ext;
    }

    public void start(String[] args) {
        try {
            if (args.length == 0) {
                processDirectoryTree(new File("."));
            } else {
                for (String arg : args) {
                    File fileArg = new File(arg);
                    if (fileArg.isDirectory()) {
                        processDirectoryTree(fileArg);
                    } else {
                        Pattern pattern = Pattern.compile(ext);
                        if (pattern.matcher(arg).matches()) {
                            mStrategy.process(new File(arg).getCanonicalFile());
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void processDirectoryTree(File root) throws IOException {
        for (File file:Directory.walk(
                root.getAbsolutePath(),ext)){
            mStrategy.process(file.getCanonicalFile());
        }
    }

    public static void main(String[] args) {
        new ProcessFiles(new ProcessFiles.Strategy(){
            @Override
            public void process(File file) {
                System.out.println(file);
            }
        },".*D.*").start(args);
    }
}
