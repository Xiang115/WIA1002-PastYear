public class Q1{
    public static void main(String[] args) {
        GenericStack<String> stack1 = new GenericStack<>(5);
        stack1.push("one");
        stack1.display();
        stack1.pushMany("two, three four, five, six seven");
        stack1.display();
        stack1.pop();
        stack1.pop();
        stack1.display();
        System.out.println("--------------------------");
        GenericStack<Integer> stack2 = new GenericStack<Integer> (5);
        stack2.push(1);
        stack2.push(2);
        stack2.pushMany ("3 4, 5, 6 7");
        stack2.display();
        stack2.popAll();
        stack2.display();
    }
}

class GenericStack<T>{
    private int size;
    private int top;
    private T[] stackArray;

    @SuppressWarnings("unchecked")
    public GenericStack(){
        this.size = 10;
        this.stackArray = (T[]) new Object[this.size];
        top = -1;
    }

    @SuppressWarnings("unchecked")
    public GenericStack(int size){
        this.size = size;
        this.stackArray = (T[]) new Object[this.size];
        top = -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == size - 1;
    }

    public T peek(){
        if(isEmpty()){
            System.out.println("Stack is empty, nothing to display...");
        }return stackArray[top];      
    }

    public void push(T item){
        if(isFull()){
            System.out.println("Stack is full...");
        }else{
            stackArray[++top] = item;
            System.out.println("Push: " + item);
        }
    }

    // if commas are involved as a delimeter it most probably can only be a string
    @SuppressWarnings("unchecked")
    public void pushMany(String items){
        String[] elements = items.split(",");       
        for (String item : elements) {
            if(isFull()){
                System.out.println("Stack is full, cannot add element " + item.trim() + " ...");
            }
            push((T) item.trim());
        }
    }

    public T pop(){
        if(isEmpty()){
            System.out.println("Stack is empty, nothing to display...");
        }
        System.out.println("Pop the top of the stack...");
        return stackArray[top--];
    }

    public void popAll() {
        System.out.println("There are " + (top + 1) + " items in the stack. Removing all...");      
        while(!isEmpty()){
            T thing = stackArray[top];
            System.out.println("Removing " + thing + " ..");
            top--;
        }System.out.println();
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Stack is empty, nothing to display...");
        }else{
            System.out.println("\nThere are " + (top + 1) + " items in the stack. Displaying...");
            for(int i = top; i >= 0; i--) 
                System.out.println(stackArray[i]); 
        }System.out.println();
    }

}