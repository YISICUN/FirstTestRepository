package EntityClone;

public class Entity implements Cloneable {
    private Integer id;
    private String name;
    private EntityValue valueEntity;
    private String[] child;

    @Override
    public Entity clone() throws CloneNotSupportedException {
        Entity entity = (Entity) super.clone();
        System.out.println("Integer,String 会复制,开辟新的内存");

        entity.setEntityValue(valueEntity.clone());
        System.out.println("嵌套结构（如对象中有对象） 不递归复制");

        entity.setChild(child.clone());
        System.out.println("非常量数组（如 int[], List<String>） 不复制元素，只复制数组引用");

        return entity;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEntityValue(EntityValue valueEntity) {
        this.valueEntity = valueEntity;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public EntityValue getEntityValue() {
        return valueEntity;
    }

    public void setChild(String[] child) {
        this.child = child;
    }

    public String[] getChild() {
        return child;
    }

}
