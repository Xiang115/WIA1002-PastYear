package GOH.PastYear2019_Sem1.Q3;

public class Q3 {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add("Computing Mathematics", 3);
        list.add("Network Architecture", 3);
        list.add("Final Year Project", 5);
        list.add("Data Structure", 5);
        list.display();
        list.totalCreditHours();
        list.addAfter("Final Year Project", "Software Modelling", 4);
        list.addAfter("Software Modelling", "Intelligent Robot", 3);
        list.addAfter("Computing Mathematics", "Gamification", 4);
        list.totalCreditHours();
        list.remove("Network Architecture", 3);
        list.remove("Software Modelling", 4);
        list.display();
        list.totalCreditHours();
    }
}

class LinkedList {

    private class Node {

        String name;
        int credit;
        Node next;

        public Node(String name, int credit) {
            this.name = name;
            this.credit = credit;
        }
    }

    Node head;
    int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(String name, int credit) {
        if (head == null) {
            head = new Node(name, credit);
        } else {
            Node temp = new Node(name, credit);
            temp.next = head;
            head = temp;
        }
        size++;
    }

    public void addAfter(String source, String name, int credit) {
        System.out.println("");
        if (isEmpty()) {
            System.out.println("The Linked list is empty");
            return;
        }

        int count = 0;
        Node curr = head;

        while (curr != null) {
            if (curr.name.equals(source)) {
                Node temp = new Node(name, credit);
                temp.next = curr.next;
                curr.next = temp;
                size++;
                break;
            }
            curr = curr.next;
            count++;
        }

        if (count == size) {
            System.out.println("Could n't find " + source);
        } else {
            System.out.println("Adding " + name + " after " + source);
        }
        System.out.println("");
    }

    public void remove(String name, int credit) {
        if (isEmpty()) {
            System.out.println("The Linked list is empty");
            return;
        }

        Node curr = head;
        Node prev = null;
        boolean tf = true;
        while (curr != null) {
            if (curr.name.equals(name)) {
                if (curr == head) {
                    head = head.next;
                } else {
                    prev.next = curr.next;
                    curr.next = null;
                }
                size--;
                tf = false;
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        size--;
        if (tf) {
            System.out.println(name + " not found in the linked list");
        } else {
            System.out.println("Removing " + name);
        }
        System.out.println("");
    }

    public void totalCreditHours() {
        int total = 0;
        Node curr = head;

        while (curr != null) {
            total += curr.credit;
            curr = curr.next;
        }
        System.out.println("Total credit hours: " + total);;
        System.out.println("");
    }

    public void display() {
        System.out.println("");
        System.out.printf("Displaying the Linked List %s\n ", "*".repeat(20));
        System.out.println("");

        Node curr = head;
        while (curr != null) {
            System.out.println(curr.name + ": " + curr.credit + " hours");
            curr = curr.next;
        }
        System.out.println("");
    }
}
