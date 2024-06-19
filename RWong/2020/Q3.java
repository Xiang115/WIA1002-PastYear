/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WIA1002;

/**
 *
 * @author HP
 */
public class Q3 {
    public static void main(String[] args) {
        LL myLL=new LL();
        
        myLL.add("Lord of The Rings", 500);
        myLL.add("Tale of the body Thief", 1);
        myLL.add("Memnoch the Devil", 100);
        myLL.add("Heart of a Samurai",10);
        myLL.display();
        myLL.addAfter("Memnoch the Devil", "White Crane", 10);
        myLL.addAfter("White Crane", "Memoirs of a Geisha", 90);
        myLL.remove("Harry Potter");
        myLL.remove("Heart of a Samurai");
        myLL.display();
    }
}

class Node<E>{
    E element;
    E element2;
    Node<E> next;
    
    public Node(){
        element=null;
        element2=null;
        next=null;
    }
    
    public Node(E o,E o2){
        element=o;
        element2=o2;
    }
}

class LL<E>{
    private Node<E> head;
    private Node<E> tail;
    private int size;
    
    public LL(){
        head=null;
        tail=null;
        size=0;
    }
    
    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }
    
    public void add(E o,E o2){
        if(isEmpty()){
            Node<E> newNode=new Node<>(o,o2);
            head=newNode;
            tail=newNode;
            size++;
        }
        else{
            Node<E> newNode=new Node<>(o,o2);
            Node<E> temp=head;
            head=newNode;
            head.next=temp;
            tail=newNode;
            size++;
        }
    }
    
    public boolean addAfter(E before,E o,E o2){
        if(isEmpty()){
            return false;
        }
        Node<E> temp=head;
        int i=1;
        System.out.println("Adding "+o+" after "+before);
        while(temp!=null){
            if(before.equals(temp.element)){
                System.out.println("Found "+temp.element+" which is book number "
                        +i+" in the linked list");
                Node<E> newNode=new Node<>(o,o2);
                newNode.next=temp.next;
                temp.next=newNode;
                size++;
                display();
                return true;
            }
            temp=temp.next;
            i++;
        }
        return false;
    }
    
    public E remove(E e){
        System.out.println("Removing "+e);
        Node<E> temp=head;
        int i=1;
        while(temp!=null){
            if(temp.element.equals(e)){
                break;
            }
            temp=temp.next;
            i++;
        }
        if(temp==head){
            System.out.println(temp.element+" is the first book. Removing "+
                    temp.element+" from the linked list");
            head=head.next;
            size--;
            return temp.element;
        }
        else if(temp==tail){
            System.out.println(temp.element+" is the last book. Removing "+
                    temp.element+" from the linked list");
            Node<E> current=head;
            for(int j=0;j<size-2;j++){
                current=current.next;
            }
            temp=tail;
            tail=current;
            tail.next=null;
            size--;
            return temp.element;
        }
        else if(size==1){
            System.out.println(temp.element+" is the only book. Removing "+
                    temp.element+" from the linked list");
            head=tail=null;
            size=0;
            return temp.element;
        }
        else if(temp==null){
            System.out.println("Couldn't find bookname...");
            return null;
        }
        else if(temp!=head && temp!=tail && temp.element.equals(e)){
            Node<E> current=head;
            while(current!=null){
                if(current.next.element.equals(temp.element)){
                    break;
                }
                current=current.next;
            }
            System.out.println(temp.element+" is the number "+i+" book. Removing "+
                    temp.element+" from the linked list");
            current.next=temp.next;
            size--;
            return temp.element;
        }
        return null;
    }
    
    public void display(){
        System.out.println("\nDisplaying the linked list**************************");
        String s="\n";
        Node<E> print=head;
        while(print!=null){
            s+=print.element+": "+print.element2+",000,000 Sold\n";
            print=print.next;
        }
        System.out.println(s);
    }
    
    public int totalSold(){
        Node<E> count=head;
        int totalSold=0;
        while(count!=null){
            totalSold+=(int)count.element2;
            count=count.next;
        }
        totalSold*=1000000;
        return totalSold;
    }
}