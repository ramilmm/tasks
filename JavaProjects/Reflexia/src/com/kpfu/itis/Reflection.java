package com.kpfu.itis;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection{
    public static void main(String[] args) {
        ExampleClass ec = new ExampleClass();
        Class c = ec.getClass();

        System.out.println("ClassName : " + c.getName());
        System.out.println("SuperClassName : " + c.getSuperclass());

        System.out.println("Fields");
        Field[] fields = c.getDeclaredFields();
        for (Field f : fields){
            Class fType = f.getType();
            int v = f.getModifiers();
            System.out.println("Type : " + fType + " Name : " + f.getName() + " Modifier : " + getModifier(f.getModifiers()));
        }
        System.out.println();
        System.out.println("Methods");
        Method[] methods = c.getMethods();
        for (Method m : methods) {
            Class type = m.getReturnType();
            Class<?>[] parameterTypes = m.getParameterTypes();
            System.out.print("ReturnType : " + type + " Name : " + m.getName() + " Modifier : " + getModifier(m.getModifiers()) + " CountOfParameters : " + m.getParameterCount());
            if (m.getParameterCount() > 0) {
                System.out.print(" TypesOfParameter : ");
                for (Class k : parameterTypes) {
                    System.out.print(k + " ");
                }
            }
            System.out.println();
        }

        System.out.println("Constuctors");
        Constructor[] constructors = c.getConstructors();
        for (Constructor constructor : constructors) {
            Class[] paramTypes = constructor.getParameterTypes();
            if(paramTypes.length == 0){
                System.out.println("Name : " + constructor.getName());
            }
            for (Class paramType : paramTypes) {
                System.out.println("Name : " + constructor.getName() + " ParametersType : " + paramType.getName());
            }
            System.out.println();
        }
    }
    public static String getModifier(int v){
        switch (v){
            case 0: {
                return "package";
            }
            case 1: {
                return "public";
            }
            case 2: {
                return "private";
            }
            case 4:{
               return "protected";
            }
        }
        return String.valueOf(-1);
    }
}
