package nonSequential;

import sequential.ArrayList;
import sequential.List;

public class MaxHeap<T extends Comparable<T>> implements Heap<T> {

    private Object[] elements;
    private int size;

    public MaxHeap() {
        this(10);
    }

    public MaxHeap(int capacity) {
        this.size = 0;
        this.elements = new Object[capacity];
    }

    @Override
    public T extract() {
        if(this.size == 0) return null;
        T max = (T) this.elements[0];
        this.size--;
        if(size > 0) { //Check that the heap is not empty
            this.elements[0] = this.elements[this.size];
        }
        this.elements[this.size] = null;
        this.siftDown(1);
        return max;
    }

    @Override
    public T get() {
        if(this.size == 0) return null;
        return (T) this.elements[0];
    }

    @Override
    public void add(T element) {
        if(this.size == this.elements.length) throw new RuntimeException("Heap is full");
        this.elements[this.size++] = element;
        this.siftUp(this.size);
    }

    @Override
    public void update(int i, T element) {
        if(i > this.size) throw new IndexOutOfBoundsException("Index is not valid");
        T temp = (T) this.elements[i-1];
        this.elements[i-1] = element;
        if(element.compareTo(temp) > 0) this.siftUp(i);
        else if(element.compareTo(temp) < 0) this.siftDown(i);
    }

    @Override
    public T remove(int i) {
        if(i > this.size) throw new IndexOutOfBoundsException("Index is not valid");
        T element = (T) this.elements[i-1];
        this.elements[i-1] = this.elements[0];
        this.siftUp(i);
        this.extract();
        return element;
    }

    @Override
    public String toString() {
        return this.toString(0);
    }

    private String toString(int level) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while(i < this.size) {
            int quantity = (int) Math.pow(2,j);
            int k = 0;
            while (k < quantity && i < this.size) {
                sb.append(this.elements[i++] + " ");
                k++;
            }
            sb.append("\n");
            j++;
        }
        return sb.toString();
    }

    private int parent(int i) {
        return i / 2;
    }

    private int leftChild(int i) {
        return i * 2;
    }

    private int rightChild(int i) {
        return i * 2 + 1;
    }

    private void siftUp(int i) {
        while (i > 1 && ((T) this.elements[parent(i) - 1]).compareTo((T )this.elements[i - 1]) <= 0) {
            T temp = (T) this.elements[parent(i) - 1];
            this.elements[parent(i) - 1] = this.elements[i - 1];
            this.elements[i - 1] = temp;
            i = parent(i);
        }
    }

    private void siftDown(int i) {
        while (i <= this.size) {
            int tempIndex = i;
            if(this.leftChild(i) <= this.size && ((T) this.elements[tempIndex - 1]).compareTo((T)this.elements[this.leftChild(i) - 1]) < 0) {
                tempIndex = this.leftChild(i);
            }
            if(this.rightChild(i) <= this.size && ((T) this.elements[tempIndex - 1]).compareTo((T)this.elements[this.rightChild(i) - 1]) < 0) {
                tempIndex = this.rightChild(i);
            }
            if(tempIndex == i) break;
            else{
                T temp = (T) this.elements[i - 1];
                this.elements[i-1] = this.elements[tempIndex- 1];
                this.elements[tempIndex - 1] = temp;
                i = tempIndex;

            }
        }
    }


}
