package Q3;

public class Q3 {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        for(int i = 10; i <= 90; i += 10) {
            queue.enqueue(i);
        }

        System.out.println("Before changing the order = " + queue);
        queue.ChangeOrder(4);
        System.out.println("After changing the order  = " + queue);
    }
}
