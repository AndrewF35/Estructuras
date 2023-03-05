package sequential;

import util.DoubleNode;
import util.Node;

import java.util.Iterator;

public class LinkedListStack<T> extends Stack<T> {

    private SinglyLinkedList<T> list;

    public LinkedListStack() {
        this.list = new SinglyLinkedList<>();
    }

    /**
     *
     * @return true if the list is empty, otherwise false
     */
    @Override
    public boolean empty() {
        return list.isEmpty();
    }

    /**
     * We reuse the get method of the singly linked list
     * @return the element stored in the head pointer
     */
    @Override
    public T peek() {
        if(this.empty()) return null;
        return list.get(0);
    }

    /**
     * We remove the element in the head pointer
     * @return the element to be removed
     */
    @Override
    public T pop() {
        if(this.empty()) return null;
        return list.remove(0);
    }

    /**
     * We add the element in the head pointer
     * @param e element to be added
     */
    @Override
    public void push(T e) {
        list.add(0, e);
    }

    /**
     * We reuse the already implemented method of indexOf of our singly linked list
     * @param e element to be searched
     * @return -1 if the element is not found, otherwise the index between 0 and n-1 where the element was found
     */
    @Override
    public int search(T e) {
        return list.indexOf(e);
    }

    /**
     *
     * @return iterator to be able of iterating the list with a foreach or while
     */
    @Override
    public Iterator<T> iterator() {
        return this.list.iterator();
    }

}
