public class StackTest {
    private int size;
    private int top;
    private String[] stackArray;

    public StackTest(int size) {
        this.size = size;
        stackArray = new String[size];
        top = -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void peek(){
        if(isEmpty()){
            System.out.println("The stack is empty.");
        }else{
            System.out.println("Peek item on top of stack: " + stackArray[top]);
        }
    }

    public void push(String string){
        if(top == size - 1){
            System.out.println("The stack is full.");
        }else{
            stackArray[++top] = string;
            System.out.println("Push item into stack: " + string);
        }
    }

    public void pop(){
        if(isEmpty()){
            System.out.println("The stack is empty.");
        }else{
            System.out.println("Pop item in stack: " + stackArray[top--]);
        }
    }

    public void popAll(){
        if(isEmpty()){
            System.out.println("The stack is empty.");
        }else{
            System.out.println("Pop all items in stack:");
            while(!isEmpty()){
                System.out.println("Removing " + stackArray[top--] + " ..");
            }
        }
    }

    public void display(){
        System.out.println("Display stack:");
        for(int i = 0; i <= top; i++){
            System.out.println(stackArray[i]);
        }
    }

    public void displayReverse(){
        System.out.println("Display stack in reverse:");
        for(int i = top; i >= 0; i--){
            System.out.println(stackArray[i]);
        }
    }

}
