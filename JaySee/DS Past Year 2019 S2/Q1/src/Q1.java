// Done with reference from https://github.com/Xiang115/WIA1002-PastYear/blob/main/RWong/2019/Q1.java
class MyLinkedList<T extends Comparable<T>>{
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T>{
        private T t;
        private Node<T> next;
        
        public Node(T t){
            this.t = t;
            this.next = null;
        }
    }

    public MyLinkedList(){}

    public int getSize(){
        return size;
    }

    public void addFirst(T t) {
        Node<T> newNode = new Node<>(t);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addLast(T t){
        Node<T> newNode = new Node<>(t);
        if(tail == null)
            head = tail = newNode;
        else{
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }

    public T removeFirst() {
        if (head == null) return null;
        T data = head.t;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return data;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[size=" + size + "]");
        for (Node<T> current = head; current != null; current = current.next) {
            builder.append(" >> ").append(current.t);
        }
        return builder.toString();
    }

    public static <T extends Comparable<T>> MyLinkedList<T> combine(MyLinkedList<T> list1, MyLinkedList<T> list2) {
        MyLinkedList<T> combined = new MyLinkedList<>();
        Node<T> first = list1.head;
        Node<T> second = list2.head;
        while (first != null && second != null) {
            if (first.t.compareTo(second.t) <= 0) {
                combined.addLast(first.t);
                first = first.next;
            } else {
                combined.addLast(second.t);
                second = second.next;
            }
        }
        Node<T> remaining = (first != null) ? first : second;
        while (remaining != null) {
            combined.addLast(remaining.t);
            remaining = remaining.next;
        }
        return combined;
    }
}

public class Q1 {
    public static void main(String[] args) {
        MyLinkedList<Integer> list1 = new MyLinkedList<>();
        MyLinkedList<Integer> list2 = new MyLinkedList<>();
        int[] arr1 = {2,10,38,41,51};
        int[] arr2 = {5,12,18,21,35,41,56};
        for(int num : arr1){
            list1.addLast(num);
        }
        for(int num : arr2){
            list2.addLast(num);
        }
        System.out.println(list1);
        System.out.println(list2);
        
        MyLinkedList<Integer> newList = MyLinkedList.combine(list1, list2);
        System.out.println(newList);
    } 
}