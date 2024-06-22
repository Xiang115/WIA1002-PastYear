package GOH.PastYear2020_Sem1.Q2;

public class Q2 {

    public static void main(String[] args) {
        GenericQueue<String> q = new GenericQueue<String>(10);
        q.enqueue("Dom T");
        q.enqueue("Rafa N");
        q.enqueueMany("Roger F,Danill M,Novak D,Alex Z,Stef T,Karen K");
        q.display();
        q.dequeue();
        q.enqueue("Matt B");
        q.enqueue("Kei N");
        q.display();
        q.dequeueAll();
        q.display();
        System.out.println("---------------------------------------");

        GenericQueue<Integer> q2 = new GenericQueue<Integer>(10);
        q2.enqueue(10);
        q2.enqueue(20);
        q2.enqueueMany("30,40,50,60,70,80,90");
        q2.display();
        q2.changeOrder(5);
        q2.display();
    }
}

class GenericQueue<E> {

    private class Node<E> {

        E val;
        Node<E> next;

        public Node(E val) {
            this.val = val;
        }
    }

    int limit, size;
    Node<E> head, tail;

    public GenericQueue(int limit) {
        this.limit = limit;
        this.size = 0;
        head = tail = null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == limit;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }

        return tail.val;
    }

    public void enqueue(E val) {
        if (isFull()) {
            System.out.println("The stack is full");
            return;
        }

        if (head == null) {
            head = new Node(val);
        } else {
            Node<E> temp = new Node(val);
            tail.next = temp;
            tail = temp;
        }

        if (tail == null) {
            tail = head;
        }
        size++;
        System.out.println("Enqueue: " + val);
    }

    public E dequeue() {
        if (isEmpty()) {
            return null;
        }

        E val = head.val;
        head = head.next;

        if (head == null) {
            tail = null;
        }
        size--;
        System.out.println("Dequeue: " + val);
        return val;
    }

    public void changeOrder(int time) {
        System.out.println("");
        if(time >= size || time < 0){
            System.out.println("The  time is unavailable");
        }
        
        for (int i = 0; i < time - 1; i++) {
            Node<E> temp = new Node(head.val);
            tail.next = temp;
            tail = temp;
            head = head.next;
        }
        System.out.println("Change queue order...");
    }

    public void display() {
        System.out.println("");
        
        if(isEmpty()){
            System.out.println("Nothing to display");
            return;
        }
        
        System.out.println("There are " + size + " items in the queue. Displaying...");
        Node<E> curr = head;

        while (curr != null) {
            System.out.print(curr.val + " | ");
            curr = curr.next;
        }
        System.out.println("");
    }
    
    public void enqueueMany(String line){
        String[] parts = line.split(",");
        
        for(String part : parts){
            enqueue((E)part);
        }
    }
    
    public void dequeueAll(){
        System.out.println("");
        System.out.println("There are " + size + " items in the queue. Removing them all...");
        
        while(!isEmpty()){
            dequeue();
        }
    }
}
