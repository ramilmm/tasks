package lesson1.lib.ru.itis.kpfu;


import java.util.Random;

public class getterRadius {

    Random rndm = new Random();
    private int r = rndm.nextInt(10);

    public int getRadius(){
        return r;
    }
}
