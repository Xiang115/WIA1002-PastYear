/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WIA1002;

/**
 *
 * @author HP
 */
public class Q4 {
    public static void main(String[] args) {
        LList list=new LList();
        
        list.add("Computing Mathematics 1", 3);
        list.add("Principles of AI", 3);
        list.add("Programming 1", 5);
        list.add("Data Structure", 5);
        //list.display();
        list.totalCreditHours();
        list.addAfter("Programming 1", "Software Architecture", 4);
        list.addAfter("Software Architecture", "Networking", 4);
        //list.display();
        list.totalCreditHours();
        list.remove("Networking", 4);
        //list.display();
        list.remove("Principles of AI", 3);
        //list.display();
        list.totalCreditHours();
    }
}

class Node<E1,E2>{
    E1 element1; 
    E2 element2;
    Node<E1,E2> next;
    
    public Node(E1 e1,E2 e2){
        element1=e1;
        element2=e2;
    }
}

class LList<String,Integer>{
    protected Node<String,Integer> head;
    protected Node<String,Integer> tail;
    protected int size;
    
    public LList(){
        head=null;
        tail=null;
        size=0;
    }
    
    public boolean isEmpty(){
        return size==0;
    }
    
    public void add(String e1,Integer e2){
        Node<String,Integer> newNode=new Node(e1,e2);
        if(isEmpty()){
            head=tail=newNode;
        }
        else{
            newNode.next=head;
            head=newNode;
        }
        size++;
    }
    
    public void addAfter(String before,String e1,Integer e2){
        System.out.println();
        Node<String,Integer> current=head;
        System.out.println("Adding "+e1+" after "+before);
        int place=1;
        while(current!=null){
            if(current.element1.equals(before)){
                System.out.println("Found "+before+" which is book number "+place+" in the linked list");
                Node<String,Integer> newNode=new Node(e1,e2);
                newNode.next=current.next;
                current.next=newNode;
                if(current==tail)
                    tail=tail.next;
                size++;
            }
            current=current.next;
            place++;
        }
    }
    
    public void remove(String e1,Integer e2){
        System.out.println();
        if(isEmpty()){
            System.out.println("The linked list is empty!");
        }
        else{
            Node<String,Integer> toberemoved=head;
            Node<String,Integer> prev=null;
            int place=1;
            System.out.println("Removing "+e1+"..");
            while(toberemoved!=null){
                if(toberemoved.element1.equals(e1) && toberemoved.element2.equals(e2)){
                    System.out.println("Found a match.. "+toberemoved.element1+" is"
                            + " book number "+place+" in the linked list");
                    if(toberemoved==head){
                        head=head.next;
                        toberemoved.next=null;
                    }
                    else if(toberemoved==tail){
                        tail=prev;
                        tail.next=null;
                    }
                    else{
                        prev.next=toberemoved.next;
                        toberemoved.next=null;
                    }
                    size--;
                    return;
                }
                prev=toberemoved;
                toberemoved=toberemoved.next;
                place++;
            }
        }
    }
    
    public void display(){
        System.out.println("\nDisplaying the linked list*********************************\n");
        Node<String,Integer> current=head;
        while(current!=null){
            System.out.println(current.element1+": "+current.element2+" hours");
            current=current.next;
        }
        System.out.println();
    }
    
    public void totalCreditHours(){
        int total=0;
        Node<String,Integer> current=head;
        while(current!=null){
            total+=(int)current.element2;
            current=current.next;
        }
        System.out.println("Total credit hours taken: "+total);
    }
}