package nonSequential;

import util.HashNode;

import java.util.Objects;

public class HashMap<K, V> implements Map<K, V> {

    private HashNode<K,V>[] table;
    private int size;
    private int capacity;

    public HashMap() {
        this(10);
    }

    public HashMap(int capacity) {
        this.capacity = capacity;
        this.table = new HashNode[this.capacity];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = this.index(this.hashCode(key));
        HashNode<K, V> chain = this.table[index];
        HashNode<K, V> head = this.table[index];
        HashNode<K, V> node = new HashNode<>(key, value);
        node.setNext(head);
        while (chain != null) {
            if(chain.getKey().equals(key)) { //Object exist we need to update
                chain.setValue(value);
                return ;
            }
            chain = chain.getNext();
        }
        //We don't find the node, so we need to add
        this.table[index] = node;
        this.size++;
        rehashing();
    }

    @Override
    public V remove(K key) {
        int index = this.index(this.hashCode(key));
        HashNode<K, V> chain = this.table[index];
        HashNode<K, V> head = this.table[index];
        HashNode<K, V> prev = null;
        while (chain != null) {
            if(chain.getKey().equals(key)) {
                break;
            }
            prev = chain;
            chain = chain.getNext();
        }
        V value = null;
        if(chain == null) //We don't find the value in the table
            return null;
        else if(prev != null) { // We delete in the middle
            value = chain.getValue();
            prev.setNext(chain.getNext());
        } else { // We delete the head
            value = chain.getValue();
            this.table[index] = head.getNext();
        }
        size--;
        return value;

    }

    @Override
    public V get(K key) {
        int index = this.index(this.hashCode(key));
        HashNode<K, V> chain = this.table[index];
        while (chain != null) {
            if(chain.getKey().equals(key)) return chain.getValue();
            chain = chain.getNext();
        }
        return null;
    }

    @Override
    public boolean hasKey(K key) {
        int index = this.index(this.hashCode(key));
        HashNode<K, V> chain = this.table[index];
        while (chain != null) {
            if(chain.getKey().equals(key)) return true;
            chain = chain.getNext();
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    private int hashCode(K key) {
        return Objects.hashCode(key);
    }

    private int index(int hash) {
        int i =  hash % capacity;
        i = i < 0 ? i * -1 : i;
        return i;
    }

    private void    rehashing() {
        if((size * 1.0) /  (capacity * 1.0) > 0.9) { //Check the load factor
            this.capacity *= 2;
            this.size = 0;
            HashNode<K,V>[] temp = table;
            table = new HashNode[capacity];
            for (int i = 0; i < temp.length; i++) {
                HashNode<K,V> chain = temp[i];
                while (chain != null) {
                    this.put(chain.getKey(), chain.getValue());
                    chain = chain.getNext();
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.table.length; i++) {
            StringBuilder sb1 = new StringBuilder();
            sb1.append(i + ": ");
            HashNode chain = this.table[i];
            while (chain != null) {
                sb1.append(chain.getKey() +"|" + chain.getValue()+ " ");
                chain = chain.getNext();
            }
            sb.append(sb1 + "\n");
        }
        return sb.toString();
    }
}
