public class Node<E> {
    E e;
    Node<E> left;
    Node<E> right;
    
    Node(E e) {
        this.e = e;
        left = null;
        right = null;
    }
    
    @Override
    public String toString() {
        return e.toString();
    }
    
}
