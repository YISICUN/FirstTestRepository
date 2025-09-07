package GenericBox;

public interface Container<T> {
    void add(T item);

    T get(int index);

    int size();
}
