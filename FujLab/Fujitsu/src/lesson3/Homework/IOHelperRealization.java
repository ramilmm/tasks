package lesson3.Homework;

import java.io.*;
import java.nio.charset.Charset;


public class IOHelperRealization implements IOHelper {
    @Override
    public long copy(InputStream in, OutputStream out) throws IOException {
        long countOfBytes = 0;

        if (in != null && in.available() > 0) {
            int b;
            while ((b = in.read()) > -1) {
                out.write(b);
                countOfBytes++;
            }
        }
        out.flush();
        return countOfBytes;
    }

    @Override
    public long copy(File source, File target) throws IOException {
        long countOfBytes = 0;
        InputStream in = new FileInputStream("C:\\Fujitsu\\src\\source.txt");
        OutputStream out = new FileOutputStream("C:\\Fujitsu\\src\\target.txt");

        int b;
        while ((b=in.read()) > -1){
            out.write(b);
            countOfBytes++;
        }
        out.flush();
        in.close();
        out.close();
        return countOfBytes;
    }

    @Override
    public String readFile(File file) throws IOException {
        String resultString = "";
        InputStream is = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "Cp1251"));

        String buf = "";
        while ((buf = br.readLine()) != null){
            resultString+=buf;
        }
        is.close();
        br.close();
        return resultString;
    }

    @Override
    public String readFile(File file, String encoding) throws IOException {
        String resultString = "";
        InputStream is = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(is, encoding));

        String buf = "";
        while ((buf = br.readLine()) != null){
            resultString+=buf;
        }
        is.close();
        br.close();
        return resultString;
    }

    @Override
    public void writeFile(File file, String content, String encoding, boolean append) throws IOException {
        IOHelperRealization io = new IOHelperRealization();
        String resultString = io.readFile(file,"cp1251");
        if(encoding==null) {
            encoding = "cp1251";
        }
        OutputStream os = new FileOutputStream(file);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os,encoding));

        resultString+=content;

        if(append) {
            bw.write(resultString);
        }else
            bw.write(content);

        bw.close();
    }

    @Override
    public InputStream createInputStream(String source) throws IOException {
        InputStream is = new ByteArrayInputStream(source.getBytes());
        return is;
    }

    @Override
    public InputStream createInputStream(String source, String encoding) throws IOException {
        InputStream is = new ByteArrayInputStream(source.getBytes(Charset.forName(encoding)));
        return is;
    }
}
