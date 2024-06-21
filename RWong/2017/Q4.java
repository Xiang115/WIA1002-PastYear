/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2017;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author HP
 */
public class Q4 {
    public static void main(String[] args) {
        Character[] alphabet={'a','b','c','d','e','f','g','h','i','j','k','l','m','n',
            'o','p','q','r','s','t','u','v','w','x','y','z'};
        Queue<Character> charac=new Queue<>(alphabet);
        System.out.println("Queue: " + charac);
        System.out.print("Index: [");
        for (int i = 0; i < charac.getSize(); i++) {
            System.out.print(i + ", ");
        }
        System.out.println("26]");
        System.out.println();
        
        Scanner sc=new Scanner(System.in);
        System.out.print("How many times will you enter a number: ");
        int num=sc.nextInt();
        System.out.println("(Please enter your number(s) between 0-26.)");
        if(num==0){
            System.out.println("The entered numbers are []");
            System.out.println("The deciphered values are -Cannot decipher. No value was entered.-");
        }
        else{
            ArrayList<Integer> indices = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                System.out.print("Enter number " + (i + 1) + " >> ");
                indices.add(sc.nextInt());
            }

            System.out.print("The entered numbers are [");
            for (int index : indices) {
                if(index==indices.get(indices.size()-1)){
                    System.out.println(index+"]");
                    break;
                }
                System.out.print(index + ", ");
            }
            
            System.out.print("The deciphered values are ");
            for (int index : indices) {
                System.out.print(charac.getElement(index));
            }
            System.out.println();
        }
    }
}

class Queue<E>{
    private ArrayList<E> queue;
    
    public Queue(E[] items){
        queue=new ArrayList<>();
        for(E item:items){
            queue.add(item);
        }
    }
    
    public Queue(){
        queue=new ArrayList<>();
    }
    
    public void enqueue(E e){
        queue.add(e);
    }
    
    public E dequeue(){
        if(isEmpty())
            return null;
        return queue.remove(0);
    }
    
    public E getElement(int i){
        if(i<0 || i>=queue.size())
            return null;
        return queue.get(i);
    }
    
    public int getSize(){
        return queue.size();
    }
    
    public boolean isEmpty(){
        return queue.isEmpty();
    }
    
    @Override
    public String toString(){
        return queue.toString();
    }
}
