package GOH.PastYear2017_Sem1.Q2;

public class Q2 {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        for (int i = 10; i < 100; i += 10) {
            queue.enqueue(i);
        }

        queue.ChangeOrder(4);
        System.out.println(queue.toString());
    }
}