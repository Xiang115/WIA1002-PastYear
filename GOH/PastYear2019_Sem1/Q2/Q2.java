package GOH.PastYear2019_Sem1.Q2;

public class Q2 {

    public static void main(String[] args) {
        GenericQueue<String> q = new GenericQueue<String>(6);
        q.enqueue("Hello");
        q.enqueueMany("all,who,wants,ice cream,or cookies");
        q.display();
        q.dequeue();
        q.dequeueAll();
        q.display();
        System.out.println("---------------------------");
        GenericQueue<Integer> q2 = new GenericQueue<Integer>(6);
        q2.enqueue(1000);
        q2.enqueue(2000);
        q2.enqueueMany("3000,4000 5000,6000,7000,8000 9000");
        q2.display();
        q2.dequeue();
        q2.dequeue();
        q2.enqueue(8000);
        q2.dequeueAll();
        q2.display();
    }
}

class GenericQueue<E> {

    E[] queue;
    int index;
    int capacity;

    public GenericQueue() {
        this(10);
    }

    public GenericQueue(int capacity) {
        queue = (E[]) new Object[capacity];
        this.capacity = capacity;
        index = 0;
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public boolean isFull() {
        return index == capacity;
    }

    public void peek() {
        System.out.println("First element of the queue: " + queue[0]);
    }

    public void enqueue(E val) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }

        queue[index++] = val;
        System.out.println("Enqueue: " + val);
    }

    public void enqueueMany(String line) {
        String[] parts = line.split(",");

        for (String part : parts) {
            enqueue((E) part);
        }
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("The queue is empty");
            return;
        }

        E temp = queue[0];
        for (int i = 1; i < index; i++) {
            queue[i - 1] = queue[i];
        }
        index--;
        System.out.println("Dequeue: " + temp);
    }

    public void dequeueAll() {
        if (isEmpty()) {
            System.out.println("The queue is empty");
            return;
        }

        System.out.println("");
        System.out.println("There are " + index + " items in the queue. Removing them all...");

        while (!isEmpty()) {
            dequeue();
        }
    }

    public void display() {
        System.out.println("");
        if (isEmpty()) {
            System.out.println("Nothing to display");
            return;
        }

        System.out.println("There are " + index + " items in the queue. Displaying...");
        for (int i = 0; i < index; i++) {
            System.out.println(queue[i]);
        }
        System.out.println("");
    }
}
