package sequential;

import java.util.Iterator;

public class LinkedListQueue<T> extends Queue<T> {

    private SinglyLinkedList<T> list;

    public LinkedListQueue() {
        this.list = new SinglyLinkedList<>();
    }

    /**
     * We add the element in tail pointer
     * @param e element to be added
     */
    @Override
    public void add(T e) {
        this.list.add(e);
    }

    /**
     * We reuse the get method of our singly linked list
     * @return element in the head pointer
     */
    @Override
    public T peek() {
        if(this.list.isEmpty()) return null;
        return this.list.get(0);
    }

    /**
     * We remove the element in the head pointer
     * @return element to be removed
     */
    @Override
    public T poll() {
        if(this.list.isEmpty()) return null;
        return this.list.remove(0);
    }

    /**
     *
     * @return true if the list is empty, otherwise false
     */
    @Override
    public boolean empty() {
        return this.list.isEmpty();
    }

    /**
     * We reuse the already implemented method of indexOf of our singly linked list
     * @param e element to be searched
     * @return -1 if the element is not found, otherwise the index between 0 and n-1 where the element was found
     */
    @Override
    public int search(T e) {
        return this.list.indexOf(e);
    }

    @Override
    public Iterator<T> iterator() {
        return this.list.iterator();
    }
}
