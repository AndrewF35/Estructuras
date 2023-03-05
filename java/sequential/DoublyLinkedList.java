package sequential;

import util.DoubleNode;
import util.Util;

import java.util.Iterator;

public class DoublyLinkedList<T> implements List<T> {
    //Pointer to the first element in the list
    private DoubleNode<T> head;
    //Pointer to the last element in the list
    private DoubleNode<T> tail;
    //Property to count the quantity of the elements in the list
    private int size;

    /**
     * We initialize the list without elements, the value null indicate that there is no elements in the list
     */
    public DoublyLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    /**
     * We called the method to add by index, indicating that the element will be added in
     * the size of the list, we did that in order to reuse the logic.
     * @param e element to be added at the end of the list
     */
    @Override
    public void add(T e) {
        this.add(this.size, e);
    }

    /**
     * Add an element by index
     * @param index index where the element will be inserted
     * @param e element to be inserted
     */
    @Override
    public void add(int index, T e) {
        Util.checkIndexOpen(index, this.size);
        //We create a new node with the value indicate as parameter
        //As we have two pointer we can categorize the insertion in three cases as following:
        // 1. We insert in the beginning of the list
        // 2. We insert in the end of the list
        // 3. We insert between beginning and end of the list
        DoubleNode<T> newNode = new DoubleNode(e);
        if (index == 0) { //Insert in the beginning
            // If there is a previous head we point the previous pointer to the new head
            if(this.head != null) {
                this.head.setPrev(newNode);
            }
            newNode.setPrev(null);
            newNode.setNext(this.head);
            this.head = newNode;
            //If it's the first element to be inserted we point the end pointer to beginning of the list
            if (this.tail == null) {
                this.tail = this.head;
            }
        } else if (index == this.size) { //Insert in the end
            this.tail.setNext(newNode);
            newNode.setPrev(this.tail);
            newNode.setNext(null);
            this.tail = newNode;
        } else { //Insert between beginning and end
            DoubleNode<T> current = this.head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            newNode.setNext(current);
            newNode.setPrev(current.getPrev());
            current.getPrev().setNext(newNode);
            current.setPrev(newNode);
        }
        this.size++;
    }

    /**
     * Remove all the elements of the list
     * We reset the pointers to null and change the quantity of elements to zero.
     * as the memory is without references it will be cleaned up by the garbage collector
     */
    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * We reuse the implemented logic by the indexOf method
     * @param e element to be search in the list
     * @return true if the element is inside the list, false otherwise
     */
    @Override
    public boolean contains(T e) {
        return this.indexOf(e) != -1;
    }

    /**
     * Check if the index is valid, otherwise throw an exception
     * @param index index of the element to be returned
     * @return the element in a specific index
     */
    @Override
    public T get(int index) {
        Util.checkIndexClose(index, this.size);
        // As we are using two pointers we categorize the login in three cases as following:
        // 1. If the index is zero we return the element referenced by the head pointer
        // 2. If the index is the last item in the list we return the element referenced by the tail pointer
        // 3  If the index is between the beginning and end of the list we decide if we traverse the list from the start
        // or the end based in quantity of steps that we have to make to reach the element
        if(index == 0) return this.head.getKey();
        if(index == this.size - 1) this.tail.getKey();
        int backIndex = this.size - 1 - index;
        DoubleNode<T> node;
        if(backIndex < index) {// Backwards search
            node = this.tail;
            for (int i = 0; i < backIndex; i++) {
                node = node.getPrev();
            }
        } else { // Forwarded search
            node = this.head;
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
        }
        return node.getKey();
    }

    /**
     * We traverse from the head until we found the next pointer as null, which indicate that we have reached
     * the end of the list.
     * @param e element to be searched in the list
     * @return the index of the element if it's found, otherwise return -1
     */
    @Override
    public int indexOf(T e) {
        DoubleNode<T> temp = this.head;
        int i = 0;
        while (temp != null) {
            if(temp.getKey().equals(e)) return i;
            i++;
            temp = temp.getNext();
        }
        return -1;
    }

    /**
     *
     * @return true if the list is empty, otherwise return false
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Remove a element by index
     * @param index of the element to be deleted
     * @return return the deleted element
     */
    @Override
    public T remove(int index) {
        //We check if the index is valid
        Util.checkIndexClose(index, this.size);
        //As we are using two pointers we can categorize in three cases as following:
        // 1. If the index is zero we need to delete at beginning, so we use the head pointer to point to next element
        // 2. If the index is equal to the size - 1 we need to delete at the end, so we use the tail pointer to point to the previous element of previous tail
        // end of the list and other that was point to the previous element then we change the tail to point to the previous
        // 3. Delete an element between the beginning and the end of the list, we need three pointers one that references to
        // current element to be deleted and another that references the previous and another that references the next element
        DoubleNode<T> temp;
        if(index == 0) {
            temp = this.head;
            this.head = temp.getNext();
            this.head.setPrev(null);
            if(this.head == null) this.tail = null;
        } else if (index == this.size - 1) {
            temp = this.tail;
            this.tail = temp.getPrev();
            this.tail.setNext(null);
        } else {
            temp = this.head;
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
            DoubleNode aft = temp.getNext();
            DoubleNode prev = temp.getPrev();
            prev.setNext(aft);
            aft.setPrev(prev);
        }
        return temp.getKey();
    }

    /**
     * We check the index of the element reusing the indexOf method, if the element is found
     * we reuse the logic to delete by index
     * @param e element to be deleted
     * @return true if the element was deleted, otherwise false
     */
    @Override
    public boolean remove(T e) {
        int index = this.indexOf(e);
        if(index != -1) {
            this.remove(index);
            return true;
        }
        return false;
    }

    /**
     *
     * @return a number indicate the size of the list
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     *
     * @return iterator to be able of iterating the list with a foreach or while
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            DoubleNode<T> node = DoublyLinkedList.this.head;
            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                T e = node.getKey();
                node = node.getNext();
                return e;
            }
        };
    }

    /**
     *
     * @return String representation of the list
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (T e: this) {
            sb.append(e);
            sb.append(",");
        }
        if(sb.length() > 1)
            sb.replace(sb.length() - 1, sb.length(), "");
        sb.append("]");
        return sb.toString();
    }
}
