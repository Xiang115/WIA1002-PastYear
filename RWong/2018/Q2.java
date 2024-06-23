/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WIA1002;

/**
 *
 * @author HP
 */
public class Q2 {
    public static void main(String[] args) {
        Queue q=new Queue(5);
        
        q.enqueue("hello");
        q.enqueue("all");
        q.enqueue("who");
        q.enqueue("wants");
        q.enqueue("ice cream");
        q.dequeue();
        q.dequeue();
        q.enqueue("1000");
        q.enqueue("2000");
        q.peek();
        
        q.display();
    }
}

class Queue<E>{
    LinkedList<E> queue;
    private int maxSize;
    
    public Queue(){
        this(20);
    }
    
    public Queue(int size){
        queue=new LinkedList();
        this.maxSize=size;
    }
    
    public boolean isEmpty(){
        return queue.size==0;
    }
    
    public void peek(){
        System.out.println("Peek(): "+queue.head.element);
    }
    
    public void enqueue(E e){
        if(queue.size==maxSize){
            System.out.println("The queue is full! Cannot add anymore items!");
        }
        else{
            queue.addLast(e);
            System.out.println("Data "+e+" inserted");
        }
    }
    
    public void dequeue(){
        if(isEmpty())
            System.out.println("The queue is empty! Nothing to be removed.");
        else
            System.out.println("Data "+queue.removeTop()+" has been removed");;
    }
    
    public void display(){
        queue.display();
    }
}

class Node<E>{
    E element;
    Node<E> next;
    
    public Node(E e){
        element=e;
    }
}

class LinkedList<E>{
    protected Node<E> head;
    protected Node<E> tail;
    protected int size;
    
    public LinkedList(){
        head=null;
        tail=null;
        size=0;
    }
    
    public void addLast(E e){
        Node<E> newNode=new Node(e);
        if(head==null){
            head=tail=newNode;
        }
        else{
            tail.next=newNode;
            tail=tail.next;
        }
        size++;
    }
    
    public E removeTop(){
        Node<E> toberemove=head;
        head=head.next;
        size--;
        return toberemove.element;
    }
    
    public void display(){
        Node<E> current=head;
        System.out.println("--------------------------------------"
                + "-----------------------------------------------");
        for(int i=0;i<size;i++){
            System.out.print("|  "+i+"  ");
        }
        System.out.println("|");
        System.out.println("--------------------------------------"
                + "-----------------------------------------------");
        while(current!=null){
            System.out.print("|  "+current.element+"  ");
            current=current.next;
        }
        System.out.println("|");
        System.out.println("--------------------------------------"
                + "-----------------------------------------------");
    }
}