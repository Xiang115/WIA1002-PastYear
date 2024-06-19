package GOH.PastYear2017_Sem1.Q4;

public class SinglyLinkedListFinals {

    private class Node {

        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    Node head;
    Node tail;

    public SinglyLinkedListFinals() {
        head = tail = null;
    }

    public void add(int val) {
        if (head == null) {
            head = new Node(val);
        } else {
            Node temp = new Node(val);
            tail.next = temp;
            tail = temp;
        }

        if (tail == null) {
            tail = head;
        }

        System.out.println("Adding: " + val);
    }

    public void addAfter(int val, int source) {
        boolean tf = false;
        Node curr = head;
        while (curr != null) {
            if (curr.val == source) {
                Node temp = new Node(val);
                temp.next = curr.next;
                curr.next = temp;

                if (curr == tail) {
                    tail = temp;
                }

                tf = true;
                break;
            }
            curr = curr.next;
        }

        if (tf) {
            System.out.println("Adding " + val + " after " + source);
        } else {
            System.out.println("Element (" + source + ") not found");
        }
    }
    
    public void deleteFront() {
        System.out.println("");
        if (head == null) {
            System.out.println("The list is empty");
        }
        int val = head.val;
        head = head.next;

        if (head == null) {
            tail = null;
        }
        System.out.println("Deleting front: " + val);
    }

    public void deleteAfter(int source) {
        System.out.println("");
        Node curr = head;
        boolean tf = false;
        int val = 0;
        if (head == null) {
            System.out.println("The lsit is empty");
        }

        System.out.println("Testing deleteAfter: ");
        while (curr != null) {
            if (curr.val == source) {
                if (curr == tail) {
                    System.out.println("After " + source + " is null");
                    return;
                } else {
                    if (curr.next == tail) {
                        tail = curr;
                    }
                    val = curr.next.val;
                    curr.next = curr.next.next;
                    tf = true;
                    break;
                }
            }
            curr = curr.next;
        }

        if (tf) {
            System.out.printf("After %d is %d. Deleting %d\n", source, val, val);
        } else {
            System.out.printf("Element (%d) not found...\n", source);
        }
    }

    public void traverse() {
        System.out.println("");
        System.out.println("Showing content of my linked list: ");
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println("");
    }
}
