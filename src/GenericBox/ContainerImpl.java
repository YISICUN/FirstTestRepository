package GenericBox;

import java.util.ArrayList;
import java.util.List;

public class ContainerImpl<T> implements Container<T> {
    private List<T> items = new ArrayList<T>();

    @Override
    public void add(T item) {
        items.add(item);
    }

    @Override
    public T get(int index) {
        return items.get(index);
    }

    @Override
    public int size() {
        return items.size();
    }

}
