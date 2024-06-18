public class DIYStack {
    private int max;
    private char[] stackArray;
    private int top;

    public DIYStack(int max) {
        this.max = max;
        stackArray = new char[max];
        top = -1;
    }

    public void push(char c) {
        stackArray[++top] = c;
    }

    public char pop() {
        return stackArray[top--];
    }

    public char peek() {
        return stackArray[top];
    }

    public boolean isStackEmpty() {
        return top == -1;
    }

    public boolean isStackFull() {
        return top == max - 1;
    }
}
