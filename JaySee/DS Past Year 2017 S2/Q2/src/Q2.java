import java.util.ArrayList;
import java.util.Scanner;

interface Stackinterface<E> {
    int size();
    E peek();
    E pop();
    void push(E item);
    boolean isEmpty();
}

class GenericStack<E> implements Stackinterface<E> {
    private ArrayList<E> stack;

    public GenericStack() {
        stack = new ArrayList<>();
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return stack.get(stack.size() - 1);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        return stack.remove(stack.size() - 1);
    }

    @Override
    public void push(E item) {
        stack.add(item);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        GenericStack<String> stack = new GenericStack<>();
        System.out.println("Create a new stack: an empty pile of books");
        System.out.println("isEmpty() returns " + stack.isEmpty());

        System.out.println("\nPush 3 books to the pile:");
        for (int i = 1; i <= 3; i++) {
            System.out.print("Enter book title " + i + ": ");
            String book = sc.nextLine();
            stack.push(book);
        }

        System.out.println("\nThe new books that you added are: " + stack);
        System.out.println("\nThe pile should not be empty: \nisEmpty() returns " + stack.isEmpty());
        System.out.println("The pile has " + stack.size() + " books.");

        System.out.println("\nGet the top book and remove the top book: \n");
        while (!stack.isEmpty()) {
            String top = stack.peek();
            System.out.println(top + " is at the top of the pile.");
            stack.pop();
            System.out.println(top + " is removed from the pile.\n");
        }

        System.out.println("The pile should be empty:");
        System.out.println("isEmpty() returns " + stack.isEmpty());
        
        sc.close();
    }
}