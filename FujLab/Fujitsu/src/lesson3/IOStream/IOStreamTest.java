package lesson3.IOStream;
import java.io.IOException;
import java.nio.charset.Charset;

public class IOStreamTest {
    public static void main(String[] args) throws IOException {
        IOStream io = new IOStream("PRIVET",Charset.forName("CP1251"));

        int num;
        while ((num = io.read()) != -1){

        }
    }
}
