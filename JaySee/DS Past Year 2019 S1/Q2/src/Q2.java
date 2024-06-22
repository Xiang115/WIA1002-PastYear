class GenericQueue<T>{
    private Node<T> depan;
    private Node<T> belakang;
    private int size;
    private int max;

    private static class Node<T>{
        private T data;
        private Node<T> next;
    
        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    public GenericQueue(int max){
        depan = null;
        belakang = null;
        size = 0;
        this.max = max;
    }

    public boolean isEmpty(){
        return depan == null;
    }

    public boolean isFull(){
        return size == max;
    }

    public T peek(){
        if(isEmpty()){
            System.out.println("Nothing to peek");
        }
        return depan.data;
    }

    public void enqueue(T data) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        Node<T> newNode = new Node<>(data);
        if (belakang != null) {
            belakang.next = newNode;
        }
        belakang = newNode;
        if (isEmpty()) {
            depan = newNode;
        }
        System.out.println("Enqueue:" + data);
        size++;
    }

    @SuppressWarnings("unchecked")
    public void enqueueMany(String item){
        String[] elements = item.split(",");
        for(String element : elements){
            enqueue((T) element.trim());
        }
    }

    public T dequeue() {
        if (depan == null) {
            System.out.println("Queue is empty");
        }
        T data = depan.data;
        depan = depan.next;
        if (depan == null) {
            belakang = null;
        }
        size--;
        System.out.println("Dequeue: " + data);
        return data;
    }

    public void dequeueAll(){
        if(isEmpty()){
            System.out.println("\nQueue is empty. Nothing to remove...");
        }else{
            System.out.println("\nThere are " + size + " items in the queue. Removing them all...");
            while(!isEmpty()){
                dequeue();
            }
        }
    }

    public void display(){
        if (isEmpty()) {
            System.out.println("\nNothing to display");
        } else {
            Node<T> current = depan;
            System.out.println("\nThere are " + size + " items in the queue. Displaying...");
            while (current != null) {
                System.out.println(current.data);
                current = current.next;
            }
            System.out.println();
        }
    }
}

public class Q2{
    public static void main(String[] args) {
        GenericQueue<String> q = new GenericQueue<String>(6);
        q.enqueue("Hello");
        q.enqueueMany ("all, who, wants, ice cream, or cookies");
        q.display();
        q.dequeue();
        q.dequeueAll();
        q.display();
        System.out.println("-------------------------");
        GenericQueue<Integer> q2 = new GenericQueue<Integer> (6);
        q2.enqueue (1000);
        q2.enqueue (2000);
        q2.enqueueMany ("3000, 4000 5000, 6000, 7000, 8000 9000");
        q2.display();
        q2.dequeue();
        q2.dequeue();
        q2.enqueue (8000);
        q2.dequeueAll();
        q2.display();
    }
}