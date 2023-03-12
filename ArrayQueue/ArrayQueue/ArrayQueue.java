package ArrayQueue;

public class ArrayQueue<T> {
    private Object[] queue;
    public int size;

    public ArrayQueue(int capacity) {
        this.queue = new Object[capacity];
        this.size = 0;
    }

    public ArrayQueue() {this(24);}

    public boolean empty() {
        return this.size == 0;
    }

    public T pop() {
        if (this.empty()) return null;
        T e = (T) this.queue[0];
        this.queue[0] = null;
        for (int i = 0; i < (this.size - 1); i++) {
            this.queue[i] = this.queue[i + 1];
        }
        this.size--;
        return e;
    }

    public T pull() {
        return (T) this.queue[0];
    }
    public void add(T e) {
    if(this.size == this.queue.length) throw new IndexOutOfBoundsException("Max size of the queue was reached");
    this.queue[this.size++] = e;
    }
}
