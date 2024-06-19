package GOH.PastYear2017_Sem1.Q3;

public class Stack<E> {

    private class Node<E> {
        E val;
        Node<E> next;

        public Node(E val) {
            this.val = val;
        }
    }

    Node<E> head;
    int size;
    int limit;

    public Stack(){
        this(20);
    }
    
    public Stack(int limit) {
        head = null;
        size = 0;
        this.limit = limit;
    }

    public void push(E val) {
        if (head == null) {
            head = new Node<>(val);
        } else {
            Node<E> temp = new Node<>(val);
            temp.next = head;
            head = temp;
        }
        size++;
    }

    public E pop(){
        E temp;
        if(head == null){
            return null;
        }else{
            temp = head.val;
            head = head.next;
        }
        size--;
        return temp;
    }
    
    public E peek(){
        return head.val;
    }
    
    public boolean isStackEmpty(){
        return size == 0;
    }
    
    public boolean isStackFull(){
        return size == limit;
    }
}