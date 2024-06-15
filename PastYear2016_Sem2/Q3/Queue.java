package Q3;

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
        return size;
    }

    public Item peek() {
        return head.val;
    }

    public void enqueue(Item val) {
        if (isEmpty()) {
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
        if (isEmpty()) {
            return null;
        }
        Item temp = head.val;
        head = head.next;

        if (head == null) {
            tail = null;
        }
        size--;
        return temp;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append('[');

        Node<Item> curr = head;
        while (curr != null) {
            sb.append(curr.val).append(", ");
            curr = curr.next;
        }
        sb.setLength(sb.length() - 2);
        sb.append(']');
        return sb.toString();
    }

    public void ChangeOrder(int k) {
        if ((k - 1) >= size) {
            return;
        }

        for (int i = 0; i < k - 1; i++) {
            enqueue(dequeue());
        }
    }
}
