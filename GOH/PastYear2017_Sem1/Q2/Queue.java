package GOH.PastYear2017_Sem1.Q2;

public class Queue<Item> {
    private class Node<Item> {

        Item val;
        Node<Item> next;

        public Node(Item val) {
            this.val = val;
        }
    }

    Node<Item> head;
    Node<Item> tail;
    int size;

    public Queue() {
        head = tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }

    public Item peek() {
        return head.val;
    }

    public void enqueue(Item val) {
        if (head == null) {
            head = new Node<>(val);
        } else {
            Node<Item> temp = new Node<>(val);
            tail.next = temp;
            tail = temp;
        }

        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public Item dequeue() {
        Item temp;
        if (head == null) {
            return null;
        } else {
            temp = head.val;
            head = head.next;
        }

        if (head == null) {
            tail = null;
        }
        size--;
        return temp;
    }

    @Override
    public String toString() {
        Node<Item> curr = head;
        String line = "Queue: ";
        while (curr.next != null) {
            line += curr.val + ", ";
            curr = curr.next;
        }
        line += curr.val;
        return line;
    }

    public void ChangeOrder(int k) {
        if(k > size || k < 1){
            return;
        }
        
        for (int i = 0; i < k - 1; i++) {
            enqueue(dequeue());
        }
    }
}
