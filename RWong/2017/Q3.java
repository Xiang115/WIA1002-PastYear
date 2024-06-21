/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2017;
import java.util.Stack;
/**
 *
 * @author HP
 */
public class Q3 {
    public static void main(String[] args) {
        BST<Integer> tree=new BST<>();
        System.out.println("5 added to the tree: "+tree.add(5));
        System.out.println("2 added to the tree: "+tree.add(2));
        System.out.println("69 added to the tree: "+tree.add(69));
        System.out.println("36 added to the tree: "+tree.add(36));
        System.out.println("45 added to the tree: "+tree.add(45));
        System.out.println("10 added to the tree: "+tree.add(10));
        System.out.println("62 added to the tree: "+tree.add(62));
        System.out.println("3 added to the tree: "+tree.add(3));
        System.out.println("5 added to the tree: "+tree.add(5));
        System.out.println();
        System.out.println("The tree contains 39: "+tree.contains(39));
        System.out.println();
        tree.printTreeInOrder();
    }
}

class BST<E extends Comparable<E>>{
    Node<E> root;
    int size;
    
    public BST(){
        root=null;
        size=0;
    }
    
    public boolean add(E item) {
        if (root == null) {
            root = new Node<>(item);
            size++;
            return true;
        }
        return add(root, item);
    }
    
    public boolean add(Node<E> node,E item){ //Blame the lecturer, the question is vague
        Node<E> current=node;
        while(current!=null){
            if(current.element==item)
                return false;
            else if(current.left==null && item.compareTo(current.element)<0){
                current.left=new Node(item);
                break;
            }
            else if(current.right==null && item.compareTo(current.element)>0){
                current.right=new Node(item);
                break;
            }
            else if(current.left!=null && item.compareTo(current.element)<0){
                current=current.left;
            }
            else if(current.right!=null && item.compareTo(current.element)>0){
                current=current.right;
            }
        }
        size++;
        return true;
    }
    
    public void printTreeInOrder(){
        System.out.print("The tree in order is: ");
        if (root == null) {
            return;
        }
        Stack<Node<E>> stack = new Stack<>();
        Node<E> current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.element + " ");
            current = current.right;
        }
        System.out.println();
    }
    
    public boolean contains(E item){
        Node<E> current=root;
        while(current!=null){
            if(current.element.equals(item))
                return true;
            else if(item.compareTo(item)<0)
                current=current.left;
            else
                current=current.right;
        }
        return false;
    }
}

class Node<E>{
    E element;
    Node<E> left;
    Node<E> right;
    
    public Node(E e){
        element=e;
    }
}
