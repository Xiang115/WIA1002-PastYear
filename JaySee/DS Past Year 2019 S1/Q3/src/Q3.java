class LinkedList{
    private Node kepalaBapakKau;

    private class Node{
        private Node next;
        private int data;
        private String subject;
    
        public Node(String subject, int data){
            this.next = null;
            this.subject = subject;
            this.data = data;
        }
    }

    public LinkedList(){
        this.kepalaBapakKau = null;
    }

    public boolean isEmpty(){
        return kepalaBapakKau == null;
    }

    public void add(String subject,int data){
        Node newNode = new Node(subject, data);
        newNode.next = kepalaBapakKau;
        kepalaBapakKau = newNode;
    }

    public void addAfter(String destination, String subject, int data){
        Node current = kepalaBapakKau;
        int num = 0;
        
        System.out.println("\nAdding " + subject + " after " + destination);
        while (current != null && !current.subject.equals(destination)) {
            current = current.next;
            num++;
        }
        if (current != null) {
            Node newNode = new Node(subject, data);
            newNode.next = current.next;
            current.next = newNode;
       }else{
            System.out.println("Book " + destination + " cannot be found");
        }
    }

    public void remove(String subject, int data){
        if (kepalaBapakKau == null) return;

        if (kepalaBapakKau.subject.equals(subject) && kepalaBapakKau.data == data) {
            System.out.println("\nRemoving " + kepalaBapakKau.subject + ".. ");
            kepalaBapakKau = kepalaBapakKau.next;
            return;
        }

        Node current = kepalaBapakKau;
        while (current.next != null && (!current.next.subject.equals(subject) || current.next.data != data)) {
            current = current.next;
        }
        if (current.next != null) {
            System.out.println("\nRemoving " + current.next.subject + ".. ");
            current.next = current.next.next;
        }
    }

    public void display(){
        Node current = kepalaBapakKau;

        System.out.println("\nDisplaying the Linked List -------------------\n");
        while (current != null) {
            System.out.println(current.subject + ": " + current.data + " hours");
            current = current.next;
        }
    }

    public void totalCreditHours(){
        int totalCredits = 0;
        Node current = kepalaBapakKau;
        while (current != null) {
            totalCredits += current.data;
            current = current.next;
        }
        System.out.println("\nTotal credit hours taken: " + totalCredits);
    }
}

public class Q3{
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
