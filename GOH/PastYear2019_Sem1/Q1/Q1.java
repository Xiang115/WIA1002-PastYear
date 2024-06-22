public class Q1 {
    public static void main(String[] args) {
        GenericStack<String> stack1 = new GenericStack<>(5);
        stack1.push("one");
        stack1.display();
        stack1.pushMany("two,three four,five,six seven");
        stack1.display();
        stack1.pop();
        stack1.pop();
        stack1.display();
        System.out.println("-------------------");
        GenericStack<Integer> stack2 = new GenericStack<>(5);
        stack2.push(1);
        stack2.push(2);
        stack2.pushMany("3 4,5,6 7");
        stack2.display();
        stack2.popAll();
        stack2.display();
    }
}

class GenericStack<E> {

    private class Node<E> {

        E val;
        Node<E> next;

        public Node(E val) {
            this.val = val;
        }
    }

    Node<E> head;
    int size, limit;

    public GenericStack(int limit) {
        this.head = null;
        this.size = 0;
        this.limit = limit;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == limit;
    }

    public void peek() {
        System.out.println("The top of the stack: " + head.val);
    }

    public void push(E val) {
        if (head == null) {
            head = new Node(val);
        } else {
            Node<E> temp = new Node(val);
            temp.next = head;
            head = temp;
        }
        System.out.println("Push: " + val);
        size++;
    }

    public void pushMany(String line) {
        String[] parts = line.split(",");

        for (String part : parts) {
            push((E) part);
        }
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("The stack is empty");
            return;
        }

        head = head.next;
        size--;
        System.out.println("Pop the top of the stack");
    }

    public void popAll() {
        if (isEmpty()) {
            System.out.println("The stack is empty");
        }

        System.out.println("There are " + size + " items in the stack. Removing all...");

        Node curr = head;
        while (curr != null) {
            System.out.println("Removing " + curr.val);
            head = head.next;
            curr = head;
            size--;
        }
    }

    public void display() {
        System.out.println("");
        if (isEmpty()) {
            System.out.println("Stack is empty, nothing to display");
            return;
        }

        System.out.println("There are " + size + " items in the stack. Displaying...");
        Node<E> curr = head;
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
        System.out.println("");
    }
}
