package lesson3.FilterOutputStream;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FOStreamTest {
    public static void main(String[] args) throws FileNotFoundException {
        FOStream fos = new FOStream(new FileOutputStream("test_count.txt"));

    }
}
