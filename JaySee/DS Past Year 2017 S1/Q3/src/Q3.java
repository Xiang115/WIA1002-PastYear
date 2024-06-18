import java.util.Scanner;

public class Q3{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a word to be reversed:");
        String input = sc.nextLine();
        String reversed = reverseWord(input);
        System.out.println("Original word: " + input);
        System.out.println("Reversed word: " + reversed);
        sc.close();
    }

    public static String reverseWord(String input) {
        int size = input.length();
        DIYStack stack = new DIYStack(size);

        for (int i = 0; i < size; i++) {
            stack.push(input.charAt(i));
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isStackEmpty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }
}