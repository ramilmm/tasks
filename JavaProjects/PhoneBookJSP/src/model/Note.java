package model;


public class Note {

    private String fio;
    private String phone;
    private Integer year;

    public Note(String fio, String phone, Integer year) {
        this.fio = fio;
        this.phone = phone;
        this.year = year;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
