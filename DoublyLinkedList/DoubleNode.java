package DoublyLinkedList;
public class DoubleNode<T> {
    private T key;
    private DoubleNode<T> next;
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

    public DoubleNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DoubleNode<T> prev) {
        this.prev = prev;
    }

    public DoubleNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }
}
