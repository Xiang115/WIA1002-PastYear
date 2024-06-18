public class Q3{
    public static void main(String[] args) {
        StackTest stack1 = new StackTest(4);
        stack1.push("one");
        stack1.push("two");
        stack1.push("three");
        stack1.push("four");
        stack1.popAll();
        stack1.displayReverse();
        System.out.println();

        StackWithGeneric<String> stack2 = new StackWithGeneric<>(4);
        stack2.push("one");
        stack2.push("two");
        stack2.push("three");
        stack2.push("four");
        System.out.println(stack2.peek());
        stack2.display();
        stack2.displayReverse();
        stack2.popAll();
        System.out.println();

        StackWithGeneric<Integer> stack3 = new StackWithGeneric<>(4);
        stack3.push(100);
        stack3.push(200);
        stack3.push(300);
        stack3.push(400);
        System.out.println(stack3.peek());
        stack3.display();
        stack3.displayReverse();
        stack3.popAll();
    }
}