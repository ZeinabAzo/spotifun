package containers;

public class Queue<T> {

    private Object[] queue;   // cannot directly create T[]
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
        queue = new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(T value) {
        if (isFull()) {
            System.out.println("Queue is full! Cannot add " + value);
            return;
        }
        rear++;
        queue[rear] = value;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Nothing to remove.");
            return null;
        }
        T removed = (T) queue[front];
        front++;
        size--;
        return removed;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        return (T) queue[front];
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Queue is empty.";
        }

        StringBuilder sb = new StringBuilder("Queue: ");
        for (int i = front; i <= rear; i++) {
            sb.append(queue[i]).append(" ");
        }

        return sb.toString().trim();
    }

}
