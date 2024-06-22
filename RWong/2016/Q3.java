/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2016;
import java.util.ArrayList;
/**
 *
 * @author HP
 */
public class Q3 {
    public static void main(String[] args) {
        Queue<Integer> order=new Queue<>();
        Integer[] values={10,20,30,40,50,60,70,80,90};
        for(Integer value:values){
            order.enqueue(value);
        }
        System.out.println("The order of the queue is: "+order.toString());
        order.ChangeOrder(4);
        System.out.println("The order of the queue after order is changed is: "+order.toString());
    }
}

class Queue<Item>{
    private ArrayList<Item> itemqueue;
    
    public Queue(){
        itemqueue=new ArrayList<>();
    }
    
    public boolean isEmpty(){
        return itemqueue.isEmpty();
    }
    
    public int size(){
        return itemqueue.size();
    }
    
    public Item peek(){
        if(isEmpty())
            return null;
        return itemqueue.get(0);
    }
    
    public void enqueue(Item e){
        itemqueue.add(e);
    }
    
    public Item dequeue(){
        return itemqueue.remove(0);
    }
    
    @Override
    public String toString(){
        return itemqueue.toString();
    }
    
    public void ChangeOrder(int k){
        for(int i=0;i<k-1 && !isEmpty();i++){
            enqueue(dequeue());
        }
    }
}