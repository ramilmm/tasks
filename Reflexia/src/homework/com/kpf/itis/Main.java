package homework.com.kpf.itis;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main extends JSONConverter{
    public static void main(String[] args) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class class_to_conver = ExampleClass.class;
      convert(class_to_conver,new ExampleClass());
    }
}
