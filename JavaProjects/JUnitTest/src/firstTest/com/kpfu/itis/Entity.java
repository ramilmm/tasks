package firstTest.com.kpfu.itis;

import java.io.Serializable;

public class Entity implements Serializable{
    private long id;
    private String name;

    public Entity(){}

    public Entity(long id,String name){
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getId(){
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entity entity = (Entity) o;

        if (id != entity.id) return false;
        return !(name != null ? !name.equals(entity.name) : entity.name != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static Entity parse(String entity){
        String[] str = entity.split(";#");

        return new Entity(Long.parseLong(str[0]),str[1]);
    }

}
