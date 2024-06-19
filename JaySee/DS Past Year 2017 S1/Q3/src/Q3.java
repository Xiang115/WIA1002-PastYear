import java.util.Scanner;

public class Q3{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a word to be reversed:");
        String input = sc.nextLine();
        String reversed = reverseWord(input);
        if(!reversed.isEmpty()){
            System.out.println("Original word: " + input);
            System.out.println("Reversed word: " + reversed);
        }else{
            System.out.println("Walao why you enter empty string?");
        }
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

class DIYStack {
    private int max;
    private char[] stackArray;
    private int top;

    public DIYStack(int max) {
        this.max = max;
        stackArray = new char[max];
        top = -1;
    }

    public void push(char c) {
        if(isStackFull()){
            System.out.println("Stack full liao, kenot push " + c);
        }else{
            stackArray[++top] = c;
        }
    }

    public char pop() {
        if(isStackEmpty()){
            System.out.println("Stack empty leh, no popping");
            return '\0';
        }else{
            return stackArray[top--];
        }
    }

    public char peek() {
        if(isStackEmpty()){
            System.out.println("Stack empty leh, why you peek peek harr");
            return '\0';
        }else{
            return stackArray[top];
        }
    }

    public boolean isStackEmpty() {
        return top == -1;
    }

    public boolean isStackFull() {
        return top == max - 1;
    }
}
