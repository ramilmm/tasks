package com.kpfu.itis;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;

@Anna(name="Ivan",surname ="Ivanchuk")
public class TestAnnotation {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class c = TestAnnotation.class;
        Annotation[] annotations = c.getAnnotations();
        for (Annotation n : annotations){
            Class<?> a = n.getClass();
            System.out.print(a.getMethod("name").invoke(n) + " ");
            System.out.println(a.getMethod("surname").invoke(n));
        }
    }
}
