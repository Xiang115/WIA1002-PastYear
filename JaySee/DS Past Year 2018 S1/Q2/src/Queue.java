public class Queue {
    private String[] elements;
    private int size;
    private int front;
    private int rear;
    // circular queue variable on the bottom

    public Queue(int size) {
        elements = new String[size];
        this.size = size;
        front = 0;
        rear = 0;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Peek(): " + elements[front]);     
        }
    }

    public void enqueue(String string) {
        if (rear == size) {
            System.out.println("Queue is full");
        } else {
            System.out.println("Data " + string + " inserted");
            elements[rear] = string;
            rear++;
        }
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Data " + elements[front] + " has been removed");
            for (int i = 0; i < rear - 1; i++) {
                elements[i] = elements[i + 1];
            }
            rear--;
        }
    }

    public void display() {
        System.out.println("-".repeat(148));
        for (int i = 0; i < rear; i++) {
            System.out.print("| " + i + " ");
        }System.out.print("|\n");
        System.out.println("-".repeat(148));
        for (int i = 0; i < rear; i++) {
            System.out.print("| " + elements[i] + " ");
        }System.out.print("|\n");
        System.out.println("-".repeat(148));
    }

    // private String[] elements;
    // private int size;
    // private int front;
    // private int rear;
    // private int count;

    // public Queue(int size) {
    //     elements = new String[size];
    //     this.size = size;
    //     front = 0;
    //     rear = 0;
    //     count = 0;
    // }

    // public boolean isEmpty() {
    //     return count == 0;
    // }

    // public boolean isFull() {
    //     return count == size;
    // }

    // public void peek() {
    //     if (isEmpty()) {
    //         System.out.println("Queue is empty");
    //     } else {
    //         System.out.println("Peek(): " + elements[front]);
    //     }
    // }

    // public void enqueue(String string) {
    //     if (isFull()) {
    //         System.out.println("Queue is full");
    //     } else {
    //         elements[rear] = string;
    //         rear = (rear + 1) % size;
    //         count++;
    //         System.out.println("Data " + string + " inserted");
    //     }
    // }

    // public void dequeue() {
    //     if (isEmpty()) {
    //         System.out.println("Queue is empty");
    //     } else {
    //         System.out.println("Data " + elements[front] + " has been removed");
    //         front = (front + 1) % size;
    //         count--;
    //     }
    // }

    // public void display() {
    //     int actualSize = count;
    
    //     System.out.println("-".repeat(148));
    //     for (int i = 0; i < actualSize; i++) {
    //         System.out.print("| " + ((front + i) % size) + " ");
    //     }System.out.println("|");
    //     System.out.println("-".repeat(148));
    //     for (int i = 0; i < actualSize; i++) {
    //         System.out.print("| " + elements[(front + i) % size] + " ");
    //     }System.out.println("|");
    //     System.out.println("-".repeat(148));
    // }
}
