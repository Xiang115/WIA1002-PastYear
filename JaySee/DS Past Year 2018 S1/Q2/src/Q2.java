public class Q2 {
    public static void main(String[] args) {
        Queue q = new Queue(5);

        q.enqueue("hello");
        q.enqueue("all");
        q.enqueue("who");
        q.enqueue("wants");
        q.enqueue("ice cream");
        q.dequeue();
        q.dequeue();
        q.enqueue("1000");
        q.enqueue("2000");
        q.peek();

        q.display();
    }
}
