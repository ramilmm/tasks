public class Human implements Comparable<Human> {
    private String FIO,EMAIL,PNUMBER,BDAY,COMMENT,JOB;
    private int id=1;

    public Human (String fio, String pnumber,String email, String bday, String job, String comment){
        this.FIO=fio;
        this.EMAIL=email;
        this.BDAY=bday;
        this.PNUMBER=pnumber;
        this.JOB=job;
        this.COMMENT=comment;
    }


    public String toString() {
        return "<a href=\"/ramil-super-puper-servlet-build-572?fio=" + this.FIO + "\">" + this.FIO + "<a/> " + "\t" + this.PNUMBER + "\t" + this.getEMAIL();
    }

    public String getFIO() {
        return FIO;
    }
    public String getEMAIL(){
        return EMAIL;
    }

    public String getPNUMBER() {
        return PNUMBER;
    }

    public String getJOB() {
        return JOB;
    }

    public String getCOMMENT() {
        return COMMENT;
    }

    public String getBDAY() {
        return BDAY;
    }

    @Override
    public int compareTo(Human h) {
        return this.FIO.compareToIgnoreCase(h.getFIO());
    }

}
