package ArrayQueue;

public class Main {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
        queue.add(2);
        queue.add(3);
        queue.add(6);
        queue.add(69);
        //System.out.println(queue.pop());
        for (int i = 0; i < 5; i++) {
            System.out.println(queue.pop());
        }
        System.out.println(queue.pull());
        queue.add(748);
        System.out.println(queue.pull());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        for (int i = 24; i > 0; i--) {
            queue.add(i);

        }
        for (int i = 0; i <= 15; i++) {
            System.out.printf("Element just removed: %d\n",queue.pop());
            System.out.printf("Size of Queue: %d\n",queue.size);
        }
        System.out.println("Intermission.");
        System.out.printf("Next to be served: %d\n",queue.pull());
        for (int i = 16; i <= 24; i++) {
            System.out.printf("Element just removed: %d\n",queue.pop());
            System.out.printf("Size of Queue: %d\n",queue.size);
        }

    }
}
