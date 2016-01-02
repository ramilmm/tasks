package lesson1.lib.ru.itis.kpfu;


import java.util.Random;

public class getterHeight {
    Random r = new Random();
    private int h = r.nextInt(10);

    public int getHeight(){
        return h;
    }
}
