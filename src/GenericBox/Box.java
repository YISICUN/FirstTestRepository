package GenericBox;

public class Box<T extends Number> implements Cloneable {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public Box() {
    }

    @Override
    public Box clone() throws CloneNotSupportedException {
        Box returnBox = (Box) super.clone();
        return returnBox;
    }

    public void setBox(T value) {
        this.value = value;
    }

    public T getBox() {
        return value;
    }

    public void printBox() {
        System.out.println("Box contains: " + value);
    }

    public BoxAddResult addBox(T value2) {
        if (value instanceof Number) {
            if (value instanceof Integer) {
                // BoxAddResult integerResult = new BoxAddResult();
                // integerResult.resulString = "OK";
                // integerResult.resulInteger = (int) value + (int) value2;
                // return integerResult;
                return new BoxAddResult("OK", (int) value + (int) value2);
            } else if (value instanceof Float) {
                return new BoxAddResult("OK", (float) value + (float) value2);
            } else {
                return new BoxAddResult("preparing...");
            }
        } else {
            return new BoxAddResult("NG");
        }
    }

}
