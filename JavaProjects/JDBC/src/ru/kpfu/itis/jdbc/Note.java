package ru.kpfu.itis.jdbc;


public class Note {
    private int id;
    private String name;
    private String pnumber;
    private String bday;

    public Note(String name,String pnumber,String bday){
        this.name=name;
        this.pnumber=pnumber;
        this.bday=bday;
    }

    public int getId(){
        return id;
    }
    public void setId(int n){
        this.id = n;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getPnumber(){
        return pnumber;
    }
    public void setPnumber(String pn){
        this.pnumber = pn;
    }
    public String getBday(){
        return bday;
    }
    public void setBday(String bd){
        this.bday = bd;
    }
}
