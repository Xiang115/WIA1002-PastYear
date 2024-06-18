public class Q3 {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        for(int i = 10; i <= 90; i += 10) {
            queue.enqueue(i);
        }

        System.out.println("Initial Queue: " + queue);
        queue.changeOrder(4);
        System.out.println("New Queue: " + queue);
    }
}

class Queue<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int size;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Queue() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public Item peek(){
        if (isEmpty()) throw new RuntimeException("Queue underflow: Empty Queue");
        return first.item;
    }

    public void enqueue(Item item) {
        Node<Item> oldLast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    public Item dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue underflow: Empty Queue");       
        Item item = first.item;
        first = first.next;
        size--;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node<Item> current = first;
        while (current != null) {
            s.append(current.item).append(" ");
            current = current.next;
        }
        return s.toString().trim();
    }

    public void changeOrder(int k) {
        if (k <= 0 || k > size) {
            throw new IllegalArgumentException("Invalid value of k");
        }
        
        for (int i = 1; i < k; i++) {
            Item item = dequeue();
            enqueue(item);
        }
        
    }
}

