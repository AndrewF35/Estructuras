package sequential;

import java.util.Iterator;

public class ArrayStack<T> extends Stack<T> {

    private Object[] list;
    private int size;
    public ArrayStack(int capacity) {
        this.list = new Object[capacity];
        this.size = 0;
    }

    public ArrayStack() {
        this(10);
    }

    /**
     *
     * @return true if the array is empty, otherwise false
     */
    @Override
    public boolean empty() {
        return this.size == 0;
    }


    /**
     * If the array is empty return null, otherwise return the value of the last position of the array
     * @return the top element of the stack
     */
    @Override
    public T peek() {
        if(this.empty()) return null;
        return (T) this.list[this.size - 1];
    }

    /**
     * If the array is empty return null, otherwise remove the value of the last position of the array
     * @return the top element of the stack
     */
    @Override
    public T pop() {
        if(this.empty()) return null;
        T e = (T) this.list[this.size - 1];
        this.list[this.size - 1] = null;
        this.size--;
        return e;
    }

    /**
     * if the quantity of the elements is equal to the size of the array throw an exception, otherwise add the element
     * in the last position of the array, which is indicated by the size property
     * @param e the value to be added
     */
    @Override
    public void push(T e) {
        if(this.size == this.list.length) throw new IndexOutOfBoundsException("Max size of the stack was reached");
        this.list[this.size++] = e;
    }

    /**
     * Traverse the array from the last position to the first and compare the element with parameter and return the index
     * @param e element to be searched in the stack
     * @return the index of the element, if the element is not found -1 is returned
     */
    @Override
    public int search(T e) {
        for (int i = this.size - 1; i >= 0; i--) {
            if(this.list[i].equals(e)) return (this.size - 1 - i);
        }
        return -1;
    }

    /**
     *
     * @return iterator to be able of iterating the list with a foreach or while
     */
    @Override
    public Iterator<T> iterator() {
        Object[] list = this.list;
        return new Iterator<T>() {
            int i = ArrayStack.this.size - 1;
            @Override
            public boolean hasNext() {
                return i >= 0;
            }

            @Override
            public T next() {
                return (T) list[i--];
            }
        };
    }

}
