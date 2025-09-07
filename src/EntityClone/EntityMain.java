package EntityClone;

public class EntityMain {
    public static void main(String[] args) throws Exception {
        System.out.println("________________________________________________________________");
        Entity entity = new Entity();
        entity.setId(1000);
        entity.setName("people");

        EntityValue valueEntity = new EntityValue();
        valueEntity.setAge(10);
        valueEntity.setMale("male");
        entity.setEntityValue(valueEntity);

        String[] child = { "child1", "child2" };
        entity.setChild(child);

        Entity cloneEntity = entity.clone();

        System.out.println("________________________________________________________________");

        cloneEntity.setId(100);
        System.out.println("cloneEntity.setId(100);");
        System.out.println(entity.getId());
        System.out.println(cloneEntity.getId());
        System.out.println("________________________________________________________________");

        cloneEntity.getEntityValue().setAge(20);
        System.out.println("cloneEntity.getEntityValue().setAge(20);");
        System.out.println(entity.getEntityValue().getAge());
        System.out.println(cloneEntity.getEntityValue().getAge());
        System.out.println("________________________________________________________________");

        cloneEntity.getChild()[0] = "change";
        System.out.println("cloneEntity.getChild()[0] = \"change\";");
        System.out.println(child[0]);
        System.out.println(cloneEntity.getChild()[0]);
        System.out.println("________________________________________________________________");

        Entity setEntity = new Entity();
        System.out.println("new一个实例,会调用构造器,,会开辟新的内存,但是需要通过手动设定来逐个复制");

        setEntity.setId(entity.getId());
        setEntity.setId(10000);
        System.out.println("setEntity.setId(entity.getId());\r\n" + //
                "setEntity.setId(10000);");
        System.out.println(entity.getId());
        System.out.println(setEntity.getId());
        System.out.println("________________________________________________________________");

    }
}
