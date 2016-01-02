package lesson3.IOStream;


import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class IOStream  extends InputStream {

    private byte[] bytes;
    private int position = 0;
    public IOStream(String source, Charset kodirovka) {
        bytes = source.getBytes(kodirovka);
    }

    @Override
    public int read() throws IOException {
        return position < bytes.length ? bytes[position++] & 0xFF:-1;
    }
}
