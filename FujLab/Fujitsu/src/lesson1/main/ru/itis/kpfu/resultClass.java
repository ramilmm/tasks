package lesson1.main.ru.itis.kpfu;

import lesson1.lib.ru.itis.kpfu.*;

public class resultClass {
    public static void main(String[] args) {
        getterHeight gh = new getterHeight();
        getterRadius gr = new getterRadius();
        System.out.println("Calculation of area...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("area = " + (int)(Math.PI*2*gh.getHeight()*gr.getRadius()));
        System.out.println("PI = " + Math.PI);
        System.out.println("Height = " + gh.getHeight());
        System.out.println("Radius = " + gr.getRadius());
    }
}
