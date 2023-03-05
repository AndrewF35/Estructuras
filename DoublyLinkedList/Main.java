package DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList <Integer> myList= new DoublyLinkedList();
        myList.add(10);
        myList.add(5);
        myList.add(0,3);
        myList.add(7);
        myList.add(1,1);
        //[3,1,10,5,7]
        for (int i = 0 ; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }
    }
}
