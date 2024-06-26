public class MyLinkedList<E> {
    Node<E> head, tail;
    int size;
    
    public MyLinkedList(){
        head = tail = null;
        size = 0;
    }
    
    public int getSize(){
        return this.size;
    }
    
    public void addFirst(E val){
        if(head == null){
            head = new Node<>(val);
        }else{
            Node<E> temp = new Node<>(val);
            temp.next = head;
            head = temp;
        }
        
        if(tail == null){
            tail = head;
        }
        size++;
    }
    
    public void addLast(E val){
        if(tail == null){
            tail = new Node<>(val);
        }else{
            Node<E> temp = new Node<>(val);
            tail.next = temp;
            tail = temp;
        }
        
        if(head == null){
            head = tail;
        }
        size++;
    }
    
    public E removeFirst(){
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
    
    @Override
    public String toString(){
        String line  = "[size=" + size + "]";
        
        Node<E> curr = head;
        while(curr != null){
            String append = " >> " + curr.val;
            line += append;
            curr = curr.next;
        }
        
        return line;
    }
}
