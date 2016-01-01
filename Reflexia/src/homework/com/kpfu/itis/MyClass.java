package homework.com.kpfu.itis;

import java.io.Serializable;
import java.util.Date;


@JSONable
public class MyClass extends Thread implements Serializable,Cloneable{
    @JSONignore
    private String IGNOREDFIELD="Ignored field";
    public int f2=124;
    protected double f3=2.114;
    @JSONname(name="Boolean")
    boolean f4=false;
    @DataFormate(format="yyyy.MM.dd")
    Date date =new Date();

    String[] arr={"abc","xyz"};
    MyClass(){}

    MyClass(String p1,boolean p4){
        this.IGNOREDFIELD=p1;
        this.f4=p4;
    }

    public void showAll(){}
    private int incF2(int d){return f2+d;}

}
