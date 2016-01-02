package homework.com.kpfu.itis;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;



public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, IOException {
        MyClass mc=new MyClass();
        Converter converter = new Converter();
        converter.convert(mc.getClass(),mc);

    }
}
