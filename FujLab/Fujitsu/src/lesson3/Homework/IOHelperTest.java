package lesson3.Homework;


import java.io.*;

public class IOHelperTest {
    public static void main(String[] args) throws IOException {
        IOHelperRealization io = new IOHelperRealization();
        File source = new File("C:\\Fujitsu\\src\\source.txt");
        File target = new File("C:\\Fujitsu\\src\\target.txt");
        //InputStream is = new FileInputStream(source);
        //OutputStream os = new FileOutputStream(target);
        //System.out.println(io.copy(is, os));

        //System.out.println(io.copy(source,target));

        //System.out.println(io.readFile(source));

        //System.out.println(io.readFile(source,"cp1251"));

        io.writeFile(target,"CONTENT","cp1251",true);
    }
}
