package GenericBox;

public class BoxMain {
    public static void main(String[] args) throws Exception {
        System.out.println("________________________________________________________________");
        System.out.println("Hello, World!");

        Box<Integer> boxInteger = new Box<>(100);
        boxInteger.setBox(1000);
        System.out.println(boxInteger.getBox());

        System.out.println(boxInteger.addBox(boxInteger.getBox()));
        System.out.println(boxInteger.addBox(boxInteger.getBox()).resultString);
        System.out.println(boxInteger.addBox(boxInteger.getBox()).resultInteger);
        System.out.println(boxInteger.addBox(boxInteger.getBox()).resulttFloat);
        System.out.println("________________________________________________________________");

        Box<Float> boxFloat = new Box<>();
        boxFloat.setBox(10.25F);
        System.out.println(boxFloat.getBox());

        System.out.println(boxFloat.addBox(boxFloat.getBox()));
        System.out.println(boxFloat.addBox(boxFloat.getBox()).resultString);
        System.out.println(boxFloat.addBox(boxFloat.getBox()).resultInteger);
        System.out.println(boxFloat.addBox(boxFloat.getBox()).resulttFloat);
        System.out.println("________________________________________________________________");

        Box<Double> boxDouble = new Box<>();
        boxDouble.setBox(13412412412.13467D);
        System.out.println(boxDouble.getBox());

        System.out.println(boxDouble.addBox(boxDouble.getBox()));
        System.out.println(boxDouble.addBox(boxDouble.getBox()).resultString);
        System.out.println(boxDouble.addBox(boxDouble.getBox()).resultInteger);
        System.out.println(boxDouble.addBox(boxDouble.getBox()).resulttFloat);
        System.out.println("________________________________________________________________");

        Box<Double> cloneBox = boxDouble.clone();
        System.out.println(boxDouble.getBox());
        System.out.println(cloneBox.getBox());
        System.out.println(boxDouble.getBox() == cloneBox.getBox());
        System.out.println(System.identityHashCode(boxDouble));
        System.out.println(System.identityHashCode(cloneBox));
        cloneBox.setBox(2D);
        System.err.println("cloneBox.setBox(2D);");
        System.out.println(boxDouble.getBox());
        System.out.println(cloneBox.getBox());
        System.out.println(boxDouble.getBox() == cloneBox.getBox());
        System.out.println("________________________________________________________________");

        Box<Double> copyBox = new Box<Double>(boxDouble.getBox());
        System.out.println(boxDouble.getBox());
        System.out.println(copyBox.getBox());
        System.out.println(boxDouble.getBox() == copyBox.getBox());
        copyBox.setBox(1D);
        System.err.println("copyBox.setBox(1D);");
        System.out.println(boxDouble.getBox());
        System.out.println(copyBox.getBox());
        System.out.println(boxDouble.getBox() == copyBox.getBox());
        System.out.println("________________________________________________________________");

        Box<Double> moveBox = boxDouble;
        System.out.println(boxDouble.getBox());
        System.out.println(moveBox.getBox());
        System.out.println(boxDouble.getBox() == moveBox.getBox());
        moveBox.setBox(3D);
        System.err.println("moveBox.setBox(3D);");
        System.out.println(boxDouble.getBox());
        System.out.println(moveBox.getBox());
        System.out.println(boxDouble.getBox() == moveBox.getBox());
        System.out.println("________________________________________________________________");

    }

}
