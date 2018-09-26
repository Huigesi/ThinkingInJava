package Exercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class TextFile extends ArrayList<String>{

    
    //读取文件，返回 String
    public static String read(String fileName){
        StringBuilder sb  =new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(
                                    new FileReader(
                                        new File(fileName).getAbsoluteFile()));
            try {
                String s ;
                //BufferedReader.readLine()  如果已到达流末尾，则返回 null 
                while ( (s = in.readLine())!= null ) {
                     sb.append(s);
                     sb.append("\n");
                     //要自己加上回车
                }
            } finally {
                in.close();
            }
            
            
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return sb.toString();    
    }//read
    
    
    
    //往文件写入 text
    public static void write(String fileName,String text){
        try {
            PrintWriter out  = new PrintWriter
                                    (new File(fileName).getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }//write
    
    
    //构造器
    public TextFile(String fileName,String splitter) {
        super(Arrays.asList( read(fileName).split(splitter))) ;
        if (get(0).equals("")) {
            remove(0);
        }
    }
    
    public TextFile(String fileName ) {
        this(fileName, "\n");//以换行号切分
    }
    
    //复制文件 写入到   文件
    public void write(String fileName){
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
                
                for (String item : this) {
                    out.print(item);
                }
            } finally {
                 out.close();
            }
             
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }//write
    
    
    public static void main(String[] args) {
        String pa = "D:\\dev2\\workspace\\seehope\\bigwork\\src\\com\\ColorChoseListener.java";
        String path2  = "D:\\dev2\\workspace\\seehope\\bigwork\\src\\io\\TextFile.java";
        String file  = read(pa);
        write("test.txt", file);
        TextFile text  = new TextFile("test.txt" );
        //以换行号切分
        
        TreeSet<String> words = new TreeSet<String>(new TextFile("src\\io\\TextFile.java" , "\\W+"));
        /*TreeSet<String> words = new TreeSet<String>(new TextFile(path2, "\\W+"));
        非词符号切分  ,
        1. 写完整路径  D:\\xx\\xx\\xx\\bigwork\\src\\io\\TextFile.java
        2.相对于此项目（bigwork）的路径（src\io\xxx.java）
        */
        
        
        // 字母开头的 码值小于  H 
        for (String string : words.headSet("H")) {
            System.out.println(string);
        }
        
         
         
        
    }
    
    
    
    
}