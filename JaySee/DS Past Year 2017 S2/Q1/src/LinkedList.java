public class LinkedList {

    private static class Node {
        String brand;
        int sold;
        Node next;

        Node(String brand, int sold) {
            this.brand = brand;
            this.sold = sold;
            this.next = null;
        }
    }

    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public void insertFirstLink(String brand, int sold) {
        Node newNode = new Node(brand, sold);
        newNode.next = head;
        head = newNode;
    }

    public void addAfter(String afterBrand, String brand, int sold) {
        Node current = head;
        int position = 1;

        while (current != null && !current.brand.equals(afterBrand)) {
            current = current.next;
            position++;
        }

        if (current != null) {
            Node newNode = new Node(brand, sold);
            newNode.next = current.next;
            current.next = newNode;
            System.out.println("Found " + afterBrand + " which is handbag number " + position + " in the linked list");
        }
    }

    public void removeLink(String brand) {
        Node current = head;
        Node previous = null;
        int position = 1;

        while (current != null && !current.brand.equals(brand)) {
            previous = current;
            current = current.next;
            position++;
        }

        if (current != null) {
            if (previous == null) {
                head = current.next;
            } else {
                previous.next = current.next;
            }
            System.out.println("Found a match.. " + brand + " is handbag number " + position + " in the linked list");
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.println(current.brand + ": " + current.sold + " Sold");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.insertFirstLink("Tods", 500000000);
        linkedList.insertFirstLink("Prada", 1000000);
        linkedList.insertFirstLink("Chanel", 100000000);
        linkedList.insertFirstLink("Louis Vuitton", 10000000);

        System.out.println("Displaying the Linked List");
        linkedList.display();

        System.out.println("\nAdding Coach after Chanel");
        linkedList.addAfter("Chanel", "Coach", 10000000);

        System.out.println("\nDisplaying the Linked List");
        linkedList.display();

        System.out.println("\nAdding Mulberry after Coach");
        linkedList.addAfter("Coach", "Mulberry", 90000000);

        System.out.println("\nDisplaying the Linked List");
        linkedList.display();

        System.out.println("\nRemoving Chanel..");
        linkedList.removeLink("Chanel");

        System.out.println("\nDisplaying the Linked List");
        linkedList.display();

        System.out.println("\nRemoving Coach..");
        linkedList.removeLink("Coach");

        System.out.println("\nDisplaying the Linked List");
        linkedList.display();
    }
}