package homework.com.kpf.itis;

@JSONable
public class DopClass{
    public int Age = 16;
    public String name = "Mike";
    public char gender = 'm';
//    private int[] array = {1,2,3,4,5};

    public int getAge(){
        return Age;
    }
    public String getName(){
        return name;
    }
    public char getGender(){
        return gender;
    }
//    public int[] getArray(){
//        return array;
//    }
}
