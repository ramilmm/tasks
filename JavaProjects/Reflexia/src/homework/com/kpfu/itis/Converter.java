package homework.com.kpfu.itis;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Converter {
    public void convert(Class c, Object obj) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException {
        String tmp = "";

        File file = new File(c.getName());

        FileOutputStream fos = new FileOutputStream(file);

        List<Field> Fields = new ArrayList<>();
        Map<String, String> refactor = new TreeMap<>();
        Map<String, String> dateFormat = new TreeMap<>();
        if (c.isAnnotationPresent(JSONable.class)) {
            Field[] fields = c.getDeclaredFields();

            for (Field field : fields) {
                if (field.isAnnotationPresent(JSONignore.class)) {
                    Fields.add(field);
                }

                for (Annotation annotation : field.getDeclaredAnnotations()) {
                    if (annotation.annotationType().getName().equals("JSONname")) {
                        Class<?> a = annotation.getClass();
                        refactor.put(field.getName(), (String) a.getMethod("name").invoke(annotation));
                    }
                    if (annotation.annotationType().getName().equals("DataFormate")) {
                        Class<?> b = annotation.getClass();
                        dateFormat.put(field.getName(), (String) b.getMethod("format").invoke(annotation));
                    }
                }
            }
            fos.write("{\n".getBytes());
            for (Field field : fields) {
                if (Fields.contains(field)) {
                    continue;
                }
                if (refactor.keySet().contains(field.getName())) {
                    tmp = "\"" + refactor.get(field.getName()) + "\":";
                    fos.write(tmp.getBytes());
                } else {
                    tmp = "\"" + field.getName() + "\":";
                    fos.write(tmp.getBytes());
                }
                field.setAccessible(true);
                try {
                    if (field.get(obj).getClass().getTypeName().equals("java.lang.String")) {
                        tmp = "\"" + field.get(obj) + "\",\n";
                        fos.write(tmp.getBytes());
                    } else if (dateFormat.keySet().contains(field.getName())) {
                        SimpleDateFormat dt = new SimpleDateFormat(dateFormat.get(field.getName()));
                        tmp = "\"" + dt.format(field.get(obj)) + "\"\n";
                        fos.write(tmp.getBytes());
                    } else {
                        Class<?> d = field.getType();
                        if (d.isArray()) {
                            fos.write("[\n{".getBytes());
                            int length = Array.getLength(field.get(obj));
                            for (int i = 0; i < length; i++) {
                                Object arrayElement = Array.get(field.get(obj), i);
                                tmp = "\"" + arrayElement + "\"";
                                fos.write(tmp.getBytes());
                                if (i < length - 1) {
                                    fos.write(",".getBytes());
                                }
                            }
                            fos.write("}\n".getBytes());
                            fos.write("]\n".getBytes());
                        } else {
                            tmp = "" + field.get(obj) + ", \n";
                            fos.write(tmp.getBytes());
                        }
                    }
                } catch (NullPointerException ex) {
                    System.out.println("Invalid format");
                    fos.write("Invalid format".getBytes());
                }

            }
            fos.write("}\n".getBytes());
        }
    }
}
