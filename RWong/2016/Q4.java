/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2016;

/**
 *
 * @author HP
 */
public class Q4 {
    public static void main(String[] args) {
        LinkedList s1=new LinkedList();
        
        s1.add(10);
        s1.add(20);
        s1.add(30);
        s1.add(40);
        s1.add(50);
        s1.addAfter(11, 10);
        s1.addAfter(21, 20);
        s1.addAfter(31, 30);
        s1.addAfter(41, 40);
        s1.addAfter(51, 50);
        s1.traverse();
        s1.deleteFront();
        s1.deleteFront();
        s1.traverse();
        s1.deleteAfter(40);
        s1.deleteAfter(40);
        s1.deleteAfter(31);
        s1.deleteAfter(40);
        s1.traverse();
    }
}

class LinkedList<Integer>{
    Node<Integer> head;
    Node<Integer> tail;
    private int size;
    
    public LinkedList(){
        head=null;
        tail=null;
        size=0;
    }
    
    public void add(int i){
        Node<Integer> newNode=new Node(i);
        System.out.println("Adding: "+newNode.element);
        if(head==null){
            head=tail=newNode;
        }
        else{
            tail.next=newNode;
            tail=newNode;
        }
        size++;
    }
    
    public boolean addAfter(int i,int j){
        System.out.println("Adding "+i+" after "+j);
        if(head==null){
            System.out.println("The linked list is not found.");
            return false;
        }
        else{
            Node<Integer> current=head;
            while(current!=null){
                if(current.element==j){
                    Node<Integer> newNode=new Node(i);
                    newNode.next=current.next;
                    current.next=newNode;
                    size++;
                    return true;
                }
                current=current.next;
            }
            return false;
        }
    }
    
    public void deleteFront(){
        Node<Integer> temp=head;
        head=head.next;
        size--;
        System.out.println("\nDeleting front: "+temp.element);
    }
    
    public void deleteAfter(int x){
        System.out.println("\nTesting deleteAfter:");
        Node<Integer> current=head;
        while(current!=null){
            if(current.element==x){
                Node<Integer> tobedel=current.next;
                System.out.println("After "+x+" is "+tobedel.element+". Deleting "+tobedel.element);
                current.next=tobedel.next;
                size--;
                return;
            }
            current=current.next;
        }
        System.out.println("Element ("+x+") not found...");
    }
    
    public void traverse(){
        System.out.println("\nShowing content of my linked list:");
        Node<Integer> current=head;
        while(current!=null){
            System.out.print(current.element+" ");
            current=current.next;
        }
        System.out.println();
    }
}

class Node<Integer>{
    int element;
    Node<Integer> next;
    
    public Node(int e){
        element=e;
    }
}