public class Stack {
    private static final int STACK_SIZE = 100;
    private int[] data;
    private int top;

    public Stack() {
        data = new int[STACK_SIZE];
        top = 0;
    }

    // Check if the stack is empty
    public boolean isStackEmpty() {
        return top == 0;
    }

    // Push an element to the stack
    public void push(int x) {
        if (top < STACK_SIZE) {
            data[top++] = x;
        } else {
            System.out.println("Error: Stack overflow");
        }
    }

    // Pop an element from the stack
    public int pop() {
        if (isStackEmpty()) {
            System.out.println("Error: Stack underflow");
            return -1;
        } else {
            return data[--top];
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        
        stack.push(100);
        stack.push(200);
        stack.push(300);

        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());
    }
}


/* 
Output :  
Popped element: 300
Popped element: 200
Popped element: 100
Error: Stack underflow
Popped element: -1
*/
