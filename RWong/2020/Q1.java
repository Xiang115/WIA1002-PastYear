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
        GenericStack<String> stack1=new GenericStack<String>(7);
        stack1.push("apple");
        System.out.println();
        
        stack1.display();
        System.out.println();
        
        stack1.pushMany("broccoli,chicken sandwich,donut,french fries,juice,maruku");
        System.out.println();

        stack1.display();
        System.out.println();
        
        System.out.println("Pop the top of the stack: "+stack1.pop());
        System.out.println("Pop the top of the stack: "+stack1.pop());
        System.out.println();
        
        stack1.display();
        System.out.println();
        
        System.out.println("Pop middle of the stack: "+stack1.popMiddle());
        System.out.println();
        
        stack1.display();
        System.out.println();
        
        System.out.println("Pop middle of the stack: "+stack1.popMiddle());
        System.out.println();
        
        stack1.display();
        System.out.println();
        System.out.println("________________________________________________");
        
        GenericStack<Integer> stack2=new GenericStack<Integer>(10);
        stack2.push(1);
        stack2.push(2);
        stack2.pushMany("3 4,5,6 7");
        System.out.println();
        
        stack2.display();
        System.out.println();
        
        stack2.popAll();
        System.out.println();
        
        stack2.display();
        System.out.println();
    }
}

class GenericStack<E>{
    private E element;
    private int size;
    private int numofelements=0;
    private E[] stack;
    
    public GenericStack(){
        this(100);
    }
    
    public GenericStack(int size){
        this.size=size;
        stack=(E[]) new Object[size];
    }
    
    public boolean isEmpty(){
        if(numofelements==0){
            return true;
        }
        return false;
    }
    
    public boolean isFull(){
        if(numofelements==size){
            return true;
        }
        return false;
    }
    
    public E peek(){
        return stack[size-1];
    }
    
    public void push(E e){
        if(isEmpty()){
            stack[size-1]=e;
            numofelements++;
            System.out.println("Push: "+e);
        }
        else if(!isFull()){
            for(int i=size-1-numofelements;i<size-1;i++){
                E temp=stack[i+1];
                stack[i]=temp;
            }
            stack[size-1]=e;
        numofelements++;
        System.out.println("Push: "+e);
        }
        else{
            System.out.println("Stack is full! Cannot add anymore items!");
        }
    }
    
    public void pushMany(String s){
        System.out.println("Push many into stack...");
        String[] items = s.split(",");
        for (String item : items) {
            E getter= (E) item;
            push(getter);
        }
    }
    
    public E pop(){
        E get=stack[size-1];
        for(int i=size-1;i>0 && !isEmpty();i--){
            E temp=stack[i-1];
            stack[i]=temp;
        }
        numofelements--;
        return get;
    }
    
    public E popMiddle(){
        if(isEmpty())
            return null;
        if(numofelements%2==0){
            System.out.println("Current count of stack is even number, so no middle index.");
            return null;
        }
        else{
            E get=stack[(size-1)-numofelements/2];
            for(int i=(size-1)-numofelements/2;i>0 && !isEmpty();i--){
                E temp=stack[i-1];
                stack[i]=temp;
            }
            numofelements--;    
            return get;
        }
    }
    
    public void popAll(){
        System.out.println("There are "+numofelements+" items in the stack. Pop all...");
        while(!isEmpty()){
            System.out.println("Removing "+pop()+"..");;
        }
    }
    
    public void display(){
        if(isEmpty())
            System.out.println("Stack is empty, nothing to display...");
        else{
            System.out.println("There are "+numofelements+" items in the stack. Displaying...");
            for(int i=size-1;i>=size-numofelements;i--){
                System.out.println(stack[i]);
            }
        }
    }
}