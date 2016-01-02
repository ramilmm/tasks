package homework.com.kpf.itis;

@JSONable
public class ExampleClass {
    @JSONname(name="age")
    public int Age = 15;
    @JSONname(name="FirstName")
    public String name = "Ramil";
    @JSONname(name="SecondName")
    public String surname = "Makhmutov";
    @JSONname(name = "Object")
    public DopClass ObjectFormat = new DopClass();
//    SimpleDateFormat date = new SimpleDateFormat("dd mm yyyy");
    @JSONname(name = "gender")
    public char gender = 'm';
    private int[] array = {1,2,3,4,5};


    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public DopClass getObjectFormat() {
        return ObjectFormat;
    }

    public void setObjectFormat(DopClass objectFormat) {
        ObjectFormat = objectFormat;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
