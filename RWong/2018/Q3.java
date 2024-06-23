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
        StackWithGeneric<String> stack1=new StackWithGeneric(4);
        stack1.push("one");
        stack1.push("two");
        stack1.push("three");
        stack1.push("four");
        System.out.println(stack1.peek());
        stack1.displayInReverse();
        stack1.popAll();
        stack1.displayInReverse();
        
        StackWithGeneric<Integer> stack2=new StackWithGeneric(4);
        stack2.push(100);
        stack2.push(200);
        stack2.push(300);
        stack2.push(400);
        System.out.println(stack2.peek());
        stack2.display();
        stack2.displayInReverse();
        stack2.popAll();
    }
}

class StackWithGeneric<E>{
    LinkedList<E> stack;
    private int maxsize;
    
    public StackWithGeneric(int k){
        stack=new LinkedList();
        this.maxsize=k;
    }
    
    public StackWithGeneric(){
        this(20);
    }
    
    public boolean isEmpty(){
        return stack.size==0;
    }
    
    public E peek(){
        return stack.tail.element;
    }
    
    public void push(E e){
        if(stack.size==maxsize){
            System.out.println("The stack is full! Cannot add anymore items!");
        }
        else{
            stack.addLast(e);
            System.out.println("Push item into stack: "+e);
        }
    }
    
    public E pop(){
        return stack.removeLast();
    }
    
    public void popAll(){
        System.out.println("Pop all item in stack: ");
        while(!isEmpty()){
            System.out.println("Removing "+pop()+" ..");
        }
    }
    
    public void display(){
        Node<E> current=stack.head;
        System.out.println("Display stack:");
        int count=0;
        for(int i=0;i<maxsize && current!=null;i++){
            System.out.println(current.element); 
            current=current.next;
            count++;
        }
        for(int i=count;i<maxsize;i++){
            System.out.println("null");
        }
    }
    
    public void displayInReverse(){
        Node<E> current=stack.head;
        System.out.print("Display stack in reverse:");
        String s="";
        int count=0;
        for(int i=0;i<maxsize && current!=null;i++){
            s="\n"+current.element+s;
            current=current.next;
            count++;
        }
        for(int i=count;i<maxsize;i++){
            s="\n"+"null"+s;
        }
        System.out.println(s);
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
    
    public E removeLast(){
        Node<E> toberemove=head;
        if(toberemove==tail){
            head=tail=null;
        }
        else{
            while(toberemove.next!=tail){
                toberemove=toberemove.next;
            }
            tail=toberemove;
            toberemove=toberemove.next;
            tail.next=null;
        }
        size--;
        return toberemove.element;
    }
}