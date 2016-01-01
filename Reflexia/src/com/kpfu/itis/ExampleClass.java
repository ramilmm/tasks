package com.kpfu.itis;


public class ExampleClass {
    private int num = 0;
    protected String s = "";
    String s2 = "";
    public double d = 4.2;

    public ExampleClass(){

    }
    public ExampleClass(int number,String str,double d){
        this.num = number;
        this.s = str;
        this.d = d;
    }

    public int getNum(){
        return num;
    }
}
