package nonSequential;

import util.HashNode;
import util.SetNode;

import java.util.Objects;

public class HashSet<V> implements Set<V> {

    private SetNode<V>[] table;
    private int size;
    private int capacity;

    public HashSet() {
        this(10);
    }

    public HashSet(int capacity) {
        this.capacity = capacity;
        this.table = new SetNode[this.capacity];
        this.size = 0;
    }
    @Override
    public void add(V value) {
        if(this.get(value) == null) {
            int index = this.index(this.hashCode(value));
            SetNode<V> chain = this.table[index];
            SetNode<V> node = new SetNode<>(value);
            node.setNext(chain);
            this.table[index] = node;
            this.size++;
            this.rehashing();
        }
    }

    @Override
    public V remove(V value) {
        int index = this.index(this.hashCode(value));
        SetNode<V> chain = this.table[index];
        SetNode<V> head = this.table[index];
        SetNode<V> prev = null;
        while (chain != null) {
            if(chain.getValue().equals(value)) {
                break;
            }
            prev = chain;
            chain = chain.getNext();
        }
        if(chain == null) return null;
        else if(prev != null) {
            prev.setNext(chain.getNext());
        } else {
            this.table[index] = head.getNext();
        }
        this.size--;
        return value;
    }

    @Override
    public V get(V value) {
        int index = this.index(this.hashCode(value));
        SetNode<V> chain = this.table[index];
        while (chain != null) {
            if(chain.getValue().equals(value)) return value;
            chain = chain.getNext();
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    private int hashCode(V key) {
        return Objects.hashCode(key);
    }

    private int index(int hash) {
        int i =  hash % capacity;
        i = i < 0 ? i * -1 : i;
        return i;
    }

    private void rehashing() {
        if((size * 1.0) /  (capacity * 1.0) > 0.9) { //Check the load factor
            this.capacity *= 2;
            this.size = 0;
            SetNode<V>[] temp = table;
            table = new SetNode[capacity];
            for (int i = 0; i < temp.length; i++) {
                SetNode<V> chain = temp[i];
                while (chain != null) {
                    this.add(chain.getValue());
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
            SetNode chain = this.table[i];
            while (chain != null) {
                sb1.append(chain.getValue()+ " ");
                chain = chain.getNext();
            }
            sb.append(sb1 + "\n");
        }
        return sb.toString();
    }


}
