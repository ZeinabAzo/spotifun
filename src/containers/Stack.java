package containers;

public class Stack<T> {

    private Object[] stack;
    private int top;
    private int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.stack = new Object[capacity];
        this.top = -1;
    }

    public void push(T value) {
        if (isFull()) {
            System.out.println("Stack is full! Cannot push " + value);
            return;
        }
        stack[++top] = value;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Nothing to pop.");
            return null;
        }
        return (T) stack[top--];
    }

    //(view top without removing)
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return (T) stack[top];
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Stack is empty.";
        }

        StringBuilder sb = new StringBuilder("Stack: ");
        for (int i = 0; i <= top; i++) {
            sb.append(stack[i]).append(" ");
        }
        return sb.toString().trim();
    }

    public int getCapacity(){
        return this.capacity;
    }
}

