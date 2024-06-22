package GOH.PastYear2020_Sem1.Q3;

public class Q3 {

    public static void main(String[] args) {
        LL myLL = new LL();
        myLL.createNode("Lord of The Rings", 500);
        myLL.createNode("Tale of the Body Thief", 1);
        myLL.createNode("Memnoch the Devil", 100);
        myLL.createNode("Heart of a Samurai", 10);
        myLL.display();
        myLL.addAfter("Memnoch the Devil", "White Crane", 10);
        myLL.addAfter("White Crane", "Memoirs of a Gesha", 90);
        myLL.removeNode("Harry Potter");
        myLL.removeNode("Heart of a Samurai");
        myLL.display();
    }
}

class LL {

    private class Node {

        String name;
        int sold;
        Node next;

        public Node(String name, int sold) {
            this.name = name;
            this.sold = sold;
        }

        public Node(String name) {
            this(name, 0);
        }
    }

    Node head;
    int size;

    public LL() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void createNode(String name, int sold) {
        add(new Node(name, sold));
    }

    public void add(Node temp) {
        temp.next = head;
        head = temp;
        size++;
    }

    public int totalSold(Node curr) {
        return curr.sold * 1_000_000;
    }

    public void display() {
        System.out.println("");
        System.out.printf("Displaying the Linked List %s\n ", "*".repeat(20));
        System.out.println("");

        Node curr = head;
        while (curr != null) {
            System.out.println(curr.name + ": " + totalSold(curr) + " Sold");
            curr = curr.next;
        }
        System.out.println("");
    }

    public void addAfter(String source, String name, int sold) {
        if (isEmpty()) {
            System.out.println("The Linked list is empty");
            return;
        }

        System.out.println("Adding " + name + " after " + source);
        int count = 0;
        Node curr = head;

        while (curr != null) {
            if (curr.name.equals(source)) {
                Node temp = new Node(name, sold);
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
            System.out.println("Find " + source + " which is book number " + (count + 1) + " in the linked list");
        }
        
        display();
    }

    public void removeNode(String source) {
        remove(new Node(source));
    }

    public void remove(Node source) {
        System.out.println("");
        if (isEmpty()) {
            System.out.println("The linked list is empty");
            return;
        }

        System.out.println("Removing " + source.name);
        String[] map = {"first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth"};
        int count = 0;
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            if (curr.name.equals(source.name)) {
                if (curr == head) {
                    head = head.next;
                } else {
                    prev.next = curr.next;
                    curr.next = null;
                }
                size--;
                break;
            }
            prev = curr;
            curr = curr.next;
        }

        if (count == size) {
            System.out.println("Could n't find bookname");
        } else {
            System.out.println(source.name + "is the " + map[count] + " book. Removing " + source.name + " from the linked list");
        }
    }
}
