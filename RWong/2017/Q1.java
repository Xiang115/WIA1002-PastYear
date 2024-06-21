/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PYQ2017;

public class Q1 {
    public static void main(String[] args) {
        LinkedList<String,Integer> handbags=new LinkedList<>();
        handbags.insertFirstLink("Tods", 500);
        handbags.insertFirstLink("Prada", 1);
        handbags.insertFirstLink("Chanel", 100);
        handbags.insertFirstLink("Louis Vuitton", 10);
        handbags.display();
        
        handbags.addAfter("Chanel", "Coach", 10);
        
        handbags.addAfter("Coach", "Mulberry", 90);
        
        handbags.removeLink("Chanel");
        
        handbags.removeLink("Coach");
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

class LinkedList<String,Integer>{
    private Node<String,Integer> head;
    private Node<String,Integer> tail;
    private int size;
    
    public LinkedList(){
        head=null;
        tail=null;
        size=0;
    }
    
    public void insertFirstLink(String a, int b){
        Node<String,Integer> newNode=new Node(a,b);
        newNode.next=head;
        head=newNode;
        if(tail==null)
            tail=head;
        size++;
    }
    
    public boolean addAfter(String before,String after,int sold){
        System.out.println("Adding "+after+" after "+before);
        if(head==null){
            System.out.println("No linked list is found!");
            return false;
        }
        int i=1;
        Node<String,Integer> check=head;
        while(check!=null){
            if(check.element1.equals(before)){
                System.out.println("Found "+before+" which is handbag number "+i+" in the linked list");
                Node<String,Integer> newNode=new Node(after,sold);
                newNode.next=check.next;
                check.next=newNode;
                size++;
                display();
                return true;
            }
            check=check.next;
            i++;
        }
        System.out.println("No match is found. Handbag cannot be added.");
        return false;
    }
    
    public boolean removeLink(String name){
        System.out.println("Removing "+name+"...");
        if(head==null){
            System.out.println("No linked list is found!");
            return false;
        }
        Node<String,Integer> current=head;
        int i=1;
        while(current!=null){
            if(current.element1.equals(name)){
                break;
            }
            current=current.next;
            i++;
        }
        if(current==head){
            System.out.println("Found a match. "+current.element1+" is handbag number 1 "
                    + "in the linked list");
            head=head.next;
            size--;
            display();
            return true;
        }
        else if(current==tail){
            System.out.println("Found a match. "+current.element1+" is handbag number "
            +size+" in the linked list");
            current=head;
            for(int j=0;j<size-2;j++){
                current=current.next;
            }
            tail=current;
            tail.next=null;
            size--;
            display();
            return true;
        }
        else if(current.element1.equals(name) && current!=tail && current!=head){
            System.out.println("Found a match. "+current.element1+" is handbag number "
            +i+" in the linked list");
            Node<String,Integer> temp=head;
            while(temp!=null){
                if(temp.next.element1.equals(name)){
                    break;
                }
            }
            temp.next=current.next;
            size--;
            display();
            return true;
        }
        else
            System.out.println("No match is found.");
        return false;
    }
    
    public void display(){
        System.out.println();
        System.out.println("Displaying the linked list************************************");
        Node<String,Integer> current=head;
        while(current!=null){
            System.out.println(current.element1+": "+current.element2+",000,000 Sold");
            current=current.next;
        }
        System.out.println();
    }
}