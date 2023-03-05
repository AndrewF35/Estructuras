package nonSequential;

public interface Map<K,V> {
    void put(K key, V value);
    V remove(K key);
    V get(K key);
    boolean hasKey(K key);
    int size();
}
