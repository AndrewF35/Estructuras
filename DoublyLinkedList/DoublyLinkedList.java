package DoublyLinkedList;


import java.util.Iterator;

public class  DoublyLinkedList<T> {
    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public static void indexOpenCheck(int index, int size){
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index not valid");
    }
    public static void indexClosedCheck(int index, int size){
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index not valid");
    }

    public void add(T j){
        this.add(this.size, j);
    }
    public void add (int index, T j){
        indexOpenCheck(index, this.size);
        DoubleNode<T> nNode = new DoubleNode(j);
        if (index == 0) {
            if(this.head != null) {
                this.head.setPrev(nNode);
            }
            nNode.setPrev(null);
            nNode.setNext(this.head);
            this.head = nNode;
            if (this.tail == null) {
                this.tail = this.head;
            }
        } else if (index == this.size) {
            this.tail.setNext(nNode);
            nNode.setPrev(this.tail);
            nNode.setNext(null);
            this.tail = nNode;
        } else {
            DoubleNode<T> currentNode = this.head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.getNext();
            }
            nNode.setNext(currentNode);
            nNode.setPrev(currentNode.getPrev());
            currentNode.getPrev().setNext(nNode);
            currentNode.setPrev(nNode);
        }
        this.size++;
    }
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public boolean contains(T e) {
        return this.indexOf(e) != -1;
    }
    public T get(int index) {
        indexClosedCheck(index, this.size);
        if(index == 0) return this.head.getKey();
        if(index == this.size - 1) return this.tail.getKey();
        int backwardsIndex = this.size - 1 - index;
        DoubleNode<T> node;
        if(backwardsIndex < index) {
            node = this.tail;
            for (int i = 0; i < backwardsIndex; i++) {
                node = node.getPrev();
            }
        } else {
            node = this.head;
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
        }
        return node.getKey();
    }
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
    public boolean isEmpty() {
        return this.size == 0;
    }

    public T remove(int index) {
        indexClosedCheck(index, this.size);
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
            DoubleNode next = temp.getNext();
            DoubleNode prev = temp.getPrev();
            prev.setNext(next);
            next.setPrev(prev);
        }
        return temp.getKey();
    }
    public boolean remove(T e) {
        int index = this.indexOf(e);
        if(index != -1) {
            this.remove(index);
            return true;
        }
        return false;
    }
    public int size() {
        return this.size;
    }
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            DoubleNode<T> node = DoublyLinkedList.this.head;

            public boolean hasNext() {
                return node != null;
            }


            public T next() {
                T e = node.getKey();
                node = node.getNext();
                return e;
            }
        };
    }

}

