package GOH.PastYear2020_Sem1.Q1;

public class Q1 {
    public static void main(String[] args) {
        GenericStack<String> stack1 = new GenericStack<String>(7);
        stack1.push("apple");
        stack1.display();
        stack1.pushMany("broccoli,chicken sandwich,donut,french fries,juice,maruku");
        stack1.display();
        System.out.println("Pop the top of the stack: " + stack1.pop());
        System.out.println("Pop the top of the stack: " + stack1.pop());
        stack1.display();
        System.out.println("Pop middle of the stack: " + stack1.popMiddle());
        stack1.display();
        System.out.println("Pop middle of the stack: " + stack1.popMiddle());
        stack1.display();
        System.out.println("------------------------------");
        GenericStack<Integer> stack2 = new GenericStack<Integer>(10);
        stack2.push(1);
        stack2.push(2);
        stack2.pushMany("3 4,5,6 7");
        stack2.display();
        stack2.popAll();
        stack2.display();
    }
}

class GenericStack<E> {

    int limit;
    int size;
    Node<E> head;

    private class Node<E> {

        E val;
        Node<E> next;

        public Node(E val) {
            this.val = val;
        }
    }

    public GenericStack(int limit) {
        head = null;
        this.limit = limit;
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
        return head.val;
    }

    public void push(E val) {
        if (isFull()) {
            System.out.println("The stack is full");
        }

        Node<E> temp = new Node(val);
        temp.next = head;
        head = temp;
        size++;
        System.out.println("Push: " + val);
    }

    public void display() {
        System.out.println("");
        if(isEmpty()){
            System.out.println("Stack is empty, nothing to display...");
            return;
        }
        
        System.out.printf("There are %d items in the stack. Displaying...\n", size);

        Node<E> curr = head;
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
        System.out.println("");
    }

    public void pushMany(String line) {
        String[] parts = line.split(",");
        System.out.println("Push many into stack...");

        for (String part : parts) {
            E val = (E) part;
            push(val);
        }
    }

    public E pop() {
        if (isEmpty()) {
            System.out.println("The stack is empty");
        }

        E val = head.val;
        head = head.next;
        size--;
        return val;
    }

    public E popMiddle() {
        if (isEmpty()) {
            System.out.println("The stack is empty");
            return null;
        }

        if (size % 2 == 0) {
            System.out.println("Current count of stack is even number, so no middle index...");
            return null;
        } else {
            int middle = size / 2;
            Node<E> curr = head;
            Node<E> prev = null;

            for (int i = 0; i < middle; i++) {
                prev = curr;
                curr = curr.next;
            }

            prev.next = curr.next;
            curr.next = null;
            size--;
            return curr.val;
        }
    }

    public void popAll() {
        if (isEmpty()) {
            System.out.println("The stack is empty");
            return;
        }
        
        System.out.println("There are " + size + " items in the stack. Pop all...");
        while(!isEmpty()){
            System.out.println("Removing: " + pop());
        }
    }
}
