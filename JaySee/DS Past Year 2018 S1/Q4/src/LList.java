class Node {
    String subject;
    int credit;
    Node next;

    public Node(String subject, int credit) {
        this.subject = subject;
        this.credit = credit;
        this.next = null;
    }
}

class LList {
    private Node head;
    private int totalCredit;

    public LList () {
        this.head = null;
    }

    public boolean isEmpty () {
        return head == null;
    }

    public void add(String subject, int credit){
        totalCredit += credit;
        Node newNode = new Node(subject, credit);
        newNode.next = head;
        head = newNode;
    }

    public void addAfter (String targetSub, String subject, int credit) {
        Node current = head;
        int num = 0;
        
        System.out.println("Adding " + subject + " after " + targetSub);
        while (current != null && !current.subject.equals(targetSub)) {
            current = current.next;
            num++;
        }
        if (current != null) {
            Node newNode = new Node(subject, credit);
            newNode.next = current.next;
            current.next = newNode;
            System.out.println("Found " + targetSub + " which is book number " + (num + 1) + " in the linked list\n");
            totalCredit += credit;
        }else{
            System.out.println("Book " + targetSub + " cannot be found");
        }
    }

    public void remove(String subject, int credit) {
        if (head == null) return;

        if (head.subject.equals(subject) && head.credit == credit) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && (!current.next.subject.equals(subject) || current.next.credit != credit)) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
            totalCredit -= credit;
        }
    }

    public void display() {
        Node current = head;

        System.out.println("Displaying the Linked List " + "*".repeat(120) + "\n");
        while (current != null) {
            System.out.println(current.subject + ": " + current.credit + " hours");
            current = current.next;
        }System.out.println();
    }

    private void totalCreditHours() {
        System.out.println("Total credit hours taken: " + totalCredit);

        // Welp below is more efficient but I am lazy to remove my counters so meh
        // int totalCredits = 0;
        // Node current = head;
        // while (current != null) {
        //     totalCredits += current.credit;
        //     current = current.next;
        // }
        // System.out.println("Total credit hours taken: " + totalCredits);
    }

    public static void main(String[] args) {
        LList list = new LList();
        list.add("Computing Mathematics 1", 3);
        list.add("Principles of AI", 3);
        list.add("Programming 1", 5);
        list.add("Data Structure", 5);
        list.display();
        list.addAfter("Programming 1", "Software Architecture", 4);
        list.display();
        list.addAfter("Software Architecture", "Networking", 4);

        list.remove("Networking", 4);
        list.display();

        list.remove("Principles of AI", 3);
        list.display();

        list.addAfter("Computing Mathematics 1", "Information Systems", 3);

        list.totalCreditHours();
    }
}
