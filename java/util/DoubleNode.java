package util;

/**
 * Utility class to build a doubly linked list, the next property is a pointer to next
 * element in the list and the prev property is a pointer to previous element in the list
 * @author Andres Gutierrez
 * @param <T> Type of the data to store
 */
public class DoubleNode<T> {
    //Property which store the value of a specific element in the list
    private T key;
    //Property which store a pointer to the following element in the list
    private DoubleNode<T> next;
    //Property which store a pointer to the previous element in the list
    private DoubleNode<T> prev;
    public DoubleNode(T key) {
        this.key = key;
        this.next = null;
        this.prev = null;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public DoubleNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    public DoubleNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DoubleNode<T> prev) {
        this.prev = prev;
    }
}
