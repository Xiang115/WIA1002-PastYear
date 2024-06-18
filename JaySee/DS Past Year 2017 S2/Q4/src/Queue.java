import java.util.Arrays;

public class Queue<E> {
    Object[] arr;
    int size;

    Queue() {
        this.arr = new Object[10];
    }

    Queue(E[] items) {
        this.arr = items;
    }

    public void enqueue(E e) {
        if(size == arr.length) {
            arr = Arrays.copyOf(arr, (int) (arr.length * 1.5));
        }
        arr[size++] = e;
    }

    public E dequeue() {
        Object elem = arr[0];
        for(int i = 0; i < size; i++) {
            arr[i] = arr[i + 1];
        }
        return (E) elem;
    }

    public E getElement(int i) {
        return (i < 0 || i >= size) ? null : (E) arr[i];
    }

    public int getSize() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        if(isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(int i = 0; i < size; i++) {
            sb.append(arr[i]);
            if(i < size - 1){
                sb.append(',').append(' ');
            }
        }
        return sb.append(']').toString();
    }
}