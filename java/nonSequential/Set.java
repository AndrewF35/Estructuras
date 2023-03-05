package nonSequential;

public interface Set<V> {
    void add(V value);
    V remove(V value);
    V get(V value);
    int size();
}
