package nonSequential;

public interface Heap<T extends Comparable<T>> {
    T extract();
    T get();
    void add(T element);
    void update(int i, T element);
    T remove(int i);
}
