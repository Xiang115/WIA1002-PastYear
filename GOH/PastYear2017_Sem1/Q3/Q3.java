package GOH.PastYear2017_Sem1.Q3;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String input = sc.nextLine();
        Stack<Character> stack = new Stack<>(input.length());

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }
        
        String reverse = "";
        while(!stack.isStackEmpty()){
            reverse += stack.pop();
        }
        
        System.out.println("The reverse word: " + reverse);
    }
}
