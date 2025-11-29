package containers;

public class LinkedList<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
            return;
        }
        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public boolean remove(T value) {
        if (head == null) return false;
        if (head.data.equals(value)) {
            head = head.next;
            return true;
        }
        Node<T> temp = head;
        while (temp.next != null && !temp.next.data.equals(value)) {
            temp = temp.next;
        }
        if (temp.next == null) return false;
        temp.next = temp.next.next;
        return true;
    }

    public boolean contains(T value) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(value)) return true;
            temp = temp.next;
        }
        return false;
    }
}
