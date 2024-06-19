package GOH.PastYear2017_Sem1.Q1;

import java.util.Stack;

public class Q1 {

    private static Stack<Integer>[] rods;
    private static int iterations = 0;

    public static void main(String[] args) {
        int n = 64;
        rods = new Stack[3];

        //0 is for first, 1 is for second, 2 is for last
        for (int i = 0; i < 3; i++) {
            rods[i] = new Stack<>();
        }

        //initialization
        for (int i = n; i > 0; i--) {
            rods[0].push(i);
        }
        display();

        //Recursion method
        // move n-1 fromt the first to the middle
        // move 1 from the first to the last
        // move n-1 from the middle to the last
        TowerofHanoi(n, rods, 0, 1, 2);
    }

    private static void display() {
        System.out.println("Iteration " + iterations + ": ");
        String[] msg = {"First rod: ", "Second rod: ", "Third rod: "};
        for (int i = 0; i < rods.length; i++) {
            System.out.print(msg[i]);
            Stack<Integer> temp = new Stack<>();
            while(!rods[i].isEmpty()){
                temp.push(rods[i].pop());
            }
            while (!temp.isEmpty()) {
                System.out.print(temp.peek() + " ");
                rods[i].push(temp.pop());
            }
            System.out.println("");
        }
        System.out.println("");
    }

    private static void TowerofHanoi(int n, Stack<Integer>[] rods, int first, int middle, int last) {
        if (n == 1) {
            rods[last].push(rods[first].pop());
            iterations++;
            display();
            return;
        }

        TowerofHanoi(n - 1, rods, first, last, middle);
        rods[last].push(rods[first].pop());
        iterations++;
        display();
        TowerofHanoi(n - 1, rods, middle, first, last);
        iterations++;
    }
}
