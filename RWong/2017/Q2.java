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
public class Q2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        GenericStack<String> books=new GenericStack<>();
        System.out.println("The new book stack is empty: "+books.isEmpty());
        for(int i=1;i<=3;i++){
            System.out.print("Enter book title "+i+": ");
            String title=sc.nextLine();
            books.push(title);
        }
        System.out.println();
        
        System.out.println("The new books that you added are: "+books.toString());
        System.out.println();
        
        System.out.println("The pile is empty: "+books.isEmpty());
        System.out.println("The pile has "+books.getsize()+" books.");
        System.out.println();
        
        System.out.println("Get the top book and remove the top book: ");
        System.out.println();
        
        while(!books.isEmpty()){
            System.out.println(books.peek()+" is at the top of the pile.");
            System.out.println(books.pop()+" is removed from the pile.");
            System.out.println();
        }
        
        System.out.println("The pile should be empty: "+books.isEmpty());
    }
}

interface StackInterface<E>{
    ArrayList element=new ArrayList<>();
    
    //A constructor
    
    public int getsize();
    
    public E peek();
    
    public E pop();
    
    public void push(E e);
    
    public boolean isEmpty();
}

class GenericStack<E> implements StackInterface<E>{
    ArrayList<E> element;
    
    public GenericStack(){
        element=new ArrayList<>();
    }
    
    public int getsize(){
        return element.size();
    }
    
    public E peek(){
        return element.get(element.size()-1);
    }
    
    public E pop(){
        return element.remove(element.size()-1);
    }
    
    public void push(E e){
        element.add(e);
    }
    
    public boolean isEmpty(){
        return element.isEmpty();
    }
    
    @Override
    public String toString(){
        return element.toString();
    }
}