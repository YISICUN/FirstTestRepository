package GenericBox;

public class ContainerMain {
    public static void main(String[] args) throws Exception {
        System.out.println("________________________________________________________________");

        ContainerImpl containerImpl = new ContainerImpl<String>();
        containerImpl.add("containerImpl item1");
        containerImpl.add("containerImpl item2");
        System.out.println(containerImpl.get(0));
        System.out.println(containerImpl.get(1));
        // System.out.println(containerImpl.get(2));
        System.out.println(containerImpl.size());
        System.out.println("________________________________________________________________");

    }

}
