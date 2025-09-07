package EntityClone;

public class EntityValue implements Cloneable {
    int age;
    String male;

    @Override
    public EntityValue clone() throws CloneNotSupportedException {
        EntityValue entity = (EntityValue) super.clone();
        return entity;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public int getAge() {
        return age;
    }

    public String getMale() {
        return male;
    }

}
