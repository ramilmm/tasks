import java.io.Serializable;

/**
 * Created by ��� on 19.11.2015.
 */
public class Target implements Serializable, Comparable{
    private int i;
    private int j;
    public Target(){}
    public Target(int i, int j) {
        setI(i);
        setJ(j);
    }

    public String toString(){
        return (getI() + 1) + " "+ (char)(getJ() + 97);
    }

    public int getI() {
        return i - 1;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j - 97;
    }

    public void setJ(int j) {
        this.j = j;
    }

    @Override
    public int compareTo(Object o) {
        return this.getI() == ((Target)o).getI() && this.getJ() == ((Target)o).getJ()? 0 : 1;
    }
}
