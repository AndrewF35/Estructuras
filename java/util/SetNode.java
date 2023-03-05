package util;

import java.util.Set;

public class SetNode<V> {
    private V value;
    private SetNode<V> next;

    public SetNode(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public SetNode<V> getNext() {
        return next;
    }

    public void setNext(SetNode<V> next) {
        this.next = next;
    }
}
