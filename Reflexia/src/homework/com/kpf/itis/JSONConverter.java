package homework.com.kpf.itis;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class JSONConverter {
    private static boolean started = false;
    public static void convert(Class c,Object o) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        boolean canConvert = false;
        if (c.isAnnotationPresent(JSONable.class)) canConvert = true;
        String fileName = c.getName();
        if (canConvert) {
            File file = null;
            if(!started) {
                 file = new File(fileName);
                if (!file.exists()) file.createNewFile();
                started = true;
            }
            FileOutputStream fos = new FileOutputStream(file);

            fos.write("{\n".getBytes());

            Field[] fields = c.getDeclaredFields();

            String str = "";
            String name = "";
            for (Field f : fields) {
                Object value = f.get(o);
                if (f.isAnnotationPresent(JSONignore.class)) continue;
                if (f.isAnnotationPresent(JSONname.class)) {
                    Annotation[] annotations = f.getAnnotations();
                    for (Annotation n : annotations) {
                        Class<?> a = n.getClass();
                        name = (String) a.getMethod("name").invoke(n);
                    }
                } else name = f.getName();
                str = "\"" + name + "\":";
                if (value instanceof String) {
                    str += "\"" + f.get(o) + "\"\n";
                    fos.write(str.getBytes());
                }else if(value instanceof Integer || value instanceof Double
                        || value instanceof Long || value instanceof Byte
                        || value instanceof Short){
                    str += f.get(new ExampleClass()) + "\n";
                    fos.write(str.getBytes());
//                }else if (f.getType().isArray()){
//                    fos.write("[".getBytes());
//                    Object[] ar = (Object[])value;
//                    for (int j = 0; j < ar.length; j++) {
//                        convert(ar[j].getClass(),new );
//                        if(j != ar.length - 1) fos.write(",".getBytes());
//                    }
                }else if (value instanceof DopClass){
                    fos.write(str.getBytes());
                    fos.write("{\n".getBytes());
                    convert(f.get(new DopClass()).getClass(),new DopClass());
                    fos.write("}\n".getBytes());
                }

            }
            fos.write("}".getBytes());
        }
    }
}
