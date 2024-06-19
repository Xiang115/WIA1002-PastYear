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
        GenericQueue<String> q=new GenericQueue<String>(10);
        q.enqueue("Dom T");
        q.enqueue("Rafa N");
        q.enqueueMany("Roger F,Daniil M,Novak D,Alex Z,Stef T,Karen K");
        System.out.println();
        
        q.display();
        q.dequeue();
        q.enqueue("Matt B");
        q.enqueue("Kei N");
        q.display();
        System.out.println();
        
        q.dequeueAll();
        q.display();
        System.out.println("_________________________________________________");
        
        GenericQueue<Integer> q2=new GenericQueue<Integer>(10);
        q2.enqueue(10);
        q2.enqueue(20);
        q2.enqueueMany("30,40,50,60,70,80,90");
        System.out.println();
        
        q2.display();
        System.out.println();
        
        q2.changeOrder(5);
        System.out.println();
        
        q2.display();
        System.out.println();
    }
}

class GenericQueue<E>{
    private E element;
    private int size;
    private int numofelements=0;
    private E[] queue;
    
    public GenericQueue(){
        this(100);
    }
    
    public GenericQueue(int size){
        this.size=size;
        queue=(E[]) new Object[size];
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
        return queue[0];
    }
    
    public void enqueue(E e){
        if(isEmpty()){
            queue[0]=e;
            numofelements++;
            System.out.println("Enqueue: "+e);
        }
        else if(!isFull()){
            queue[numofelements]=e;
        numofelements++;
        System.out.println("Enqueue: "+e);
        }
        else{
            System.out.println("Queue is full! Cannot add anymore items!");
        }
    }
    
    public void enqueueMany(String s){
        String[] items = s.split(",");
        for (String item : items) {
            E getter= (E) item;
            enqueue(getter);
        }
    }
    
    public void dequeue(){
        E get=queue[0];
        for(int i=0;i<numofelements && !isEmpty();i++){
            queue[i]=queue[i+1];
        }
        numofelements--;
        System.out.println("Dequeue "+get);
    }
    
    public void dequeueAll(){
        System.out.println("There are "+numofelements+" in the queue. Removing them all...");
        while(!isEmpty()){
            dequeue();
        }
    }
    
    public void changeOrder(int k){
        E[] temp=(E[])new Object[k-1];
        for(int i=0;i<k-1;i++){
            temp[i]=queue[i];
        }
        System.out.println("Change queue order...");
        for(int i=0;i<k;i++){
            queue[i]=queue[k-1+i];
        }
        int count=0;
        for(int j=k;j<numofelements;j++){
            queue[j]=temp[count++];
        }
    }
    
    public void display(){
        if(isEmpty())
            System.out.println("Nothing to display.");
        else{
            System.out.println("There are "+numofelements+" items in the queue. Displaying...");
            for(int i=0;i<numofelements;i++){
                System.out.print(queue[i]+"|");
            }
            System.out.println();
        }
    }
}