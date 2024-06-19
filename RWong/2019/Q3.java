/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WIA1002;
import java.util.ArrayList;
/**
 *
 * @author HP
 */
public class Q3 {
    
}

class Node<E>{
    Node<E> left;
    Node<E> right;
    Node<E> up;
    Node<E> down;
    E x;
    E y;
    
    public Node(E x1,E y1){
        x=x1;
        y=y1;
    }
}

class Stack<E> {
    private ArrayList<E> list = new ArrayList<>();

    public void push(E item) {
        list.add(item);
    }

    public E pop() {
        return list.remove(list.size()-1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public E peek() {
        return list.get(list.size()-1);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
