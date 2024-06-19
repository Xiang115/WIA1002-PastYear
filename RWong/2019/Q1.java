/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WIA1002;

/**
 *
 * @author HP
 */
public class Q1 {
    public static void main(String[] args) {
        MyLinkedList<Integer> list1=new MyLinkedList<>();
        MyLinkedList<Integer> list2=new MyLinkedList<>();
        MyLinkedList<Integer> newList=new MyLinkedList<>();
        int[] arr1={2,10,38,41,51};
        int[] arr2={5,12,18,21,35,41,56};
        for(int num:arr1){
            list1.addLast(num);
        }
        for(int num:arr2){
            list2.addLast(num);
        }
        System.out.println(list1.toString());
        System.out.println(list2.toString());
        newList=newList.combine(list1, list2);
        System.out.println(newList.toString());
    } 
}

class Node<E>{
    protected E item;
    protected Node<E> next;
    
    public Node(E e){
        item=e;
    }
}

class MyLinkedList<E extends Comparable<E>>{
    private Node<E> head;
    private Node<E> tail;
    private int size;
    
    public MyLinkedList(){
        head=null;
        tail=null;
        size=0;
    }
    
    public int getSize(){
        return size;
    }
    
    public void addFirst(E e){
        Node<E> newNode=new Node<>(e);
        newNode.next=head;
        head=newNode;
        if(tail==null)
            tail=head;
        size++;
    }
    
    public void addLast(E e){
        Node<E> newNode=new Node<>(e);
        if(tail==null)
            head=tail=newNode;
        else{
            tail.next=newNode;
            tail=tail.next;
        }
        size++;
    }
    
    public E removeFirst(){
        if(head==null)
            return null;
        else{
            Node<E> temp=head;
            head=head.next;
            size--;
            if(head==null)
                tail=null;
            return temp.item;
        }
    }
    
    @Override
    public String toString(){
        String s="[size="+size+"]";
        Node<E> temp=head;
        while(temp!=null){
            s+=" >> "+temp.item;
            temp=temp.next;
        }
        return s;
    }
    
    public MyLinkedList<E> combine(MyLinkedList<E> list1,MyLinkedList<E> list2){
        MyLinkedList<E> combined=new MyLinkedList<>();
        Node<E> first=list1.head;
        Node<E> second=list2.head;
        while(first!=null && second!=null){
            if(first.item.compareTo(second.item)<0){
                combined.addLast(first.item);
                first=first.next;
            }
            else if(first.item.compareTo(second.item)>0){
                combined.addLast(second.item);
                second=second.next;
            }
            else{
                combined.addLast(first.item);
                first=first.next;
                combined.addLast(second.item);
                second=second.next;
            }
        }
        if(first!=null){
            while(first!=null){
                combined.addLast(first.item);
                first=first.next;
            }
        }
        else{
            while(second!=null){
                combined.addLast(second.item);
                second=second.next;
            }
        }
        return combined;
    } 
}