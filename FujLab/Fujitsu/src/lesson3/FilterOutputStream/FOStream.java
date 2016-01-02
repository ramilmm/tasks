package lesson3.FilterOutputStream;


import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FOStream  extends FilterOutputStream {

    private long count;

    public FOStream(OutputStream out) {
        super(out);
        count = 0;
    }


    public void write(int b) throws IOException {
        super.write(b);
        count++;
    }


}
