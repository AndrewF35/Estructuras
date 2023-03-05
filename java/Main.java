import nonSequential.*;
import sequential.*;

/**
 * @author Andres Gutierrez
 */
public class Main {
    public static void main(String[] args) {

//        List<Integer> myList = new ArrayList<>(5);
//        List<Integer> myList = new SinglyLinkedList();
//
//        myList.add(10);
//        myList.add(5);
//        myList.add(0,3);
//        myList.add(7);
//        myList.add(1,1);
//        //[3,1,10,5,7]
//        System.out.println(myList);
//        myList.add(0, 9);
//        myList.add(9);
//        System.out.println(myList.size());
//        System.out.println(myList);
//        System.out.println(myList.contains(10));
//        System.out.println(myList.contains(2));
//        System.out.println(myList.indexOf(10));
//        myList.remove(Integer.valueOf(10));
//        System.out.println(myList);
//        myList.remove(0);
//        System.out.println(myList);
//        System.out.println(myList.isEmpty());
//        myList.clear();
//        System.out.println(myList.isEmpty());
//        System.out.println(myList);
//
//        myList.add(2);
//        myList.add(5);
//        myList.add(0,1);
//        myList.add(2,4);
//        myList.add(2,3);
//        myList.add(6);
//        //[1,2,3,4,5,6]
//        for (Integer el: myList) {
//            System.out.println(el);
//        }
//        System.out.println(myList.get(3));

        // STACK
//        Stack<String> stack = new ArrayStack<>();
//        stack.push("Andres");
//        stack.push("Rene");
//        stack.push("Mario");
//        System.out.println(stack);
//        stack.push("Samuel");
//        stack.push("Natalia");
//        stack.push("Maria");
//        stack.push("Nancy");
//        stack.push("Cristian");
//        stack.push("Daniel");
//        stack.push("Nubia");
//        System.out.println(stack.search("Daniel"));
//
//        System.out.println(stack);
//        try {
//            stack.push("Valentina");
//        } catch (Exception e) {
//            System.out.println("Max size");
//        }
//        System.out.println(stack.peek());
//        System.out.println(stack.pop());
//        while (!stack.empty()) {
//            stack.pop();
//        }
//        System.out.println(stack.empty());
//        stack.push("Andres");
//        stack.push("Samuel");
//        System.out.println(stack);
//        System.out.println(stack.empty());
//        System.out.println(stack.search("Carlos"));

        // QUEUE

//        Queue<String> queue = new LinkedListQueue<>();
//        queue.toString();
//        queue.add("Andres");
//        queue.add("Rene");
//        queue.add("Mario");
//        System.out.println(queue);
//        queue.add("Samuel");
//        queue.add("Natalia");
//        queue.add("Maria");
//        queue.add("Nancy");
//        queue.add("Cristian");
//        queue.add("Daniel");
//        queue.add("Nubia");
//        System.out.println(queue);
//        System.out.println(queue.peek());
//        System.out.println(queue.poll());
//        while (!queue.empty()) {
//            queue.poll();
//        }
//        System.out.println(queue.empty());
//        queue.add("Andres");
//        queue.add("Samuel");
//        System.out.println(queue);
//        System.out.println(queue.empty());

        //TREE
//        BinaryTree<String> tree = new RecursiveBinarySearchTree<>();
//        System.out.println("Size: " + tree.size());
//        System.out.println("Height: " + tree.height());
//
//        System.out.println(tree.search("Andres"));
//
//        tree.insert("Andres");
//        tree.insert("Ana");
//        tree.insert("Camilo");
//        tree.insert("Juanita");
//        tree.insert("Beto");
//        tree.insert("Fabio");
//        System.out.println("------------------------------");
//        System.out.println(tree);
//        System.out.println("------------------------------");
//
//        System.out.println(tree.search("Andres"));
//        System.out.println(tree.search("Fabioooo"));
//        System.out.println(tree.search("Camilo"));
//
//
//        System.out.println("Size: " + tree.size());
//        System.out.println("Height: " + tree.height());
//        System.out.println("Max: " + tree.maxValue());
//        System.out.println("Min: " + tree.minValue());
//
//        tree.delete("Juanita");
//        tree.delete("Andres");
//
//        System.out.println("------------------------------");
//        System.out.println(tree);
//        System.out.println("------------------------------");
//
//        System.out.println(tree.search("Camilo"));
//
//        System.out.println("Size: " + tree.size());
//        System.out.println("Height: " + tree.height());
//        System.out.println("Max: " + tree.maxValue());
//        System.out.println("Min: " + tree.minValue());
//
//        tree.inOrder();
//        System.out.println();
//        tree.preOrder();
//        System.out.println();
//        tree.postOrder();
//        System.out.println();
//
//        System.out.println("Balanced " + tree.isBalanced());
//        tree.insert("Nancy");
//        tree.insert("Julian");
//        tree.insert("Samuel");
//        System.out.println("Balanced " + tree.isBalanced());
//        System.out.println("------------------------------");
//        System.out.println(tree);
//        System.out.println("------------------------------");
//        tree.balance();
//        System.out.println("Balanced " + tree.isBalanced());
//        System.out.println("------------------------------");
//        System.out.println(tree);
//        System.out.println("------------------------------");

//        BinaryTree<Integer> tree = new AvlBinarySearch<>();
//        tree.insert(8);
//        tree.insert(15);
//        tree.insert(2);
//        tree.insert(13);
//        tree.insert(11);
//        tree.insert(9);

//        Heap<Integer> maxHeap = new MaxHeap<>(20);
//        maxHeap.add(4);
//        maxHeap.add(10);
//        maxHeap.add(9);
//        maxHeap.add(15);
//        maxHeap.add(11);
//        System.out.println("--------------------------");
//        System.out.println(maxHeap);
//        System.out.println("--------------------------");
//        maxHeap.add(20);
//        System.out.println("--------------------------");
//        System.out.println(maxHeap);
//        System.out.println("--------------------------");
//
//        System.out.println(maxHeap.get());
//        maxHeap.extract();
//
//        System.out.println("--------------------------");
//        System.out.println(maxHeap);
//        System.out.println("--------------------------");
//
//        maxHeap.extract();
//
//        System.out.println("--------------------------");
//        System.out.println(maxHeap);
//        System.out.println("--------------------------");
//
//        maxHeap.add(14);
//        maxHeap.add(15);
//        maxHeap.add(17);
//        maxHeap.add(18);
//
//        System.out.println("--------------------------");
//        System.out.println(maxHeap);
//        System.out.println("--------------------------");
//
//        maxHeap.update(8, 22);
//
//        System.out.println("--------------------------");
//        System.out.println(maxHeap);
//        System.out.println("--------------------------");
//
//        maxHeap.update(2, 12);
//
//        System.out.println("--------------------------");
//        System.out.println(maxHeap);
//        System.out.println("--------------------------");
//
//        int element = maxHeap.remove(6);
//        System.out.println(element);
//
//        System.out.println("--------------------------");
//        System.out.println(maxHeap);
//        System.out.println("--------------------------");

//        DisjointUnionSets sets = new DisjointUnionSets(8);
//        System.out.println(sets);
//
//        System.out.println(sets.find(0) == sets.find(5));
//        sets.union(0,7);
//        sets.union(2,1);
//        sets.union(2,3);
//        sets.union(7,4);
//        sets.union(5,6);
//        System.out.println(sets);
//        System.out.println(sets.find(0) == sets.find(5));
//        sets.union(0,1);
//        System.out.println(sets);
//        System.out.println(sets.find(0) == sets.find(5));
//        sets.union(0,6);
//        System.out.println(sets);
//        System.out.println(sets.find(0) == sets.find(5));
//
//        sets.find(6);
//        sets.find(3);
//        sets.find(1);
//        System.out.println(sets);

//        Map<String, Integer> map = new HashMap<>();
//        map.put("Andres", 10);
//        map.put("Samuel",15);
//        map.put("Daniel", 2);
//        map.put("Nancy",9);
//        System.out.println(map.get("Andres"));
//        System.out.println(map.hasKey("Andres"));
//        System.out.println(map.hasKey("Camila"));
//        System.out.println("-------------------------------------");
//        System.out.println(map);
//        System.out.println("-------------------------------------");
//        map.put("Daniel", 50);
//        map.put("Alejandra", 2);
//        map.put("Sonia", 3);
//        map.put("Rene", 100);
//        map.put("Fernando", 25);
//        map.put("Mario", 100);
//        map.put("Maria", 110);
//        map.put("Camila", 1);
//
//        System.out.println(map.hasKey("Camila"));
//        System.out.println(map.get("Camila"));
//
//        map.remove("Javier");
//        map.remove("Andres");
//
//        System.out.println("-------------------------------------");
//        System.out.println(map);
//        System.out.println("-------------------------------------");
//
//        map.put("Carlos", -1);
//        map.put("Javier", 0);
//        map.put("Hernando", -10);
//        map.put("Jairo", 0);
//
//        map.remove("Camila");
//        map.remove("Fernando");
//
//        System.out.println(map.hasKey("Camila"));
//        System.out.println("-------------------------------------");
//        System.out.println(map);
//        System.out.println("-------------------------------------");

        Set<String> set = new HashSet<>();

        set.add("Andres");
        set.add("Carlos");
        set.add("Maria");
        System.out.println("-------------------------------------");
        System.out.println(set);
        System.out.println("-------------------------------------");
        System.out.println(set.get("Maria"));
        System.out.println(set.get("Nancy"));

        set.add("Nancy");
        set.add("Daniel");
        set.add("Samuel");
        set.add("Carlos");
        set.add("Sofia");
        System.out.println("-------------------------------------");
        System.out.println(set);
        System.out.println("-------------------------------------");

        set.remove("Caterine");
        set.remove("Carlos");
        set.remove("Nancy");

        System.out.println("-------------------------------------");
        System.out.println(set);
        System.out.println("-------------------------------------");

        set.add("Caterine");
        set.add("Carlos");
        set.add("Nancy");
        set.add("Javier");
        set.add("Fernando");

        System.out.println("-------------------------------------");
        System.out.println(set);
        System.out.println("-------------------------------------");
    }
}
