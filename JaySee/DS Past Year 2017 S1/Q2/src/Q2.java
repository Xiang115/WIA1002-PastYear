public class Q2 {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        for(int i = 10; i < 100; i+=10) {
            queue.enqueue(i);
        }

        System.out.println("Initial Queue: " + queue);
        queue.changeOrder(4); 
        System.out.println("New Queue: " + queue);
    }
}
