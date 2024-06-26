public class Stack<E> {
    private class Node<E>{
        E val;
        Node<E> next;
        
        public Node(E val){
            this.val = val;
        }
    }
    
    Node<E> head;
    int size;
    
    public Stack(){
        head = null;
        size = 0;
    }
    
    public void push(E val){
        if(head == null){
            head = new Node<>(val);
        }else{
            Node<E> temp = new Node(val);
            temp.next = head;
            head = temp;
        }
        size++;
    }
    
    public E peek(){
        return head.val;
    }
    
    public E pop(){
        E val;
        if(head == null){
            return null;
        }else{
            val = head.val;
            head = head.next;
        }
        size--;
        return val;
    }
    
    public int size(){
        return this.size;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
}