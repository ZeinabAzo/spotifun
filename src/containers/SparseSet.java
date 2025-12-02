package containers;

public class SparseSet<T> {
    private T[] dense;
    private int[] sparse;
    private int size;
    private int capacity;    // max elements
    private int maxId;       // max possible ID

    @SuppressWarnings("unchecked")
    public SparseSet(int capacity, int maxId) {
        this.capacity = capacity;
        this.maxId = maxId;
        this.size = 0;
        this.dense = (T[]) new Object[capacity];
        this.sparse = new int[maxId + 1];  // one extra for 0-based indexing
    }

    public boolean contains(int id) {
        if (id < 0 || id > maxId) return false;
        int idx = sparse[id];
        return idx < size && dense[idx] != null && getId(dense[idx]) == id;
    }

    public void add(T element) {
        int id = getId(element);

        if (contains(id))
            throw new IllegalArgumentException("Duplicate ID");

        if (size >= capacity)
            throw new IllegalStateException("Capacity full");

        dense[size] = element;
        sparse[id] = size;
        size++;
    }

    public void remove(int id) {
        if (!contains(id))
            throw new IllegalArgumentException("ID not found");

        int idx = sparse[id];
        // to remove we switch places between last element and the id's element
        T last = dense[size - 1];

        // swapping
        dense[idx] = last;
        sparse[getId(last)] = idx;

        dense[size - 1] = null;
        size--;
    }

    public T get(int id) {
        if (!contains(id)) return null;
        return dense[sparse[id]];
    }

    public T[] all() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[size];
        for (int i = 0; i < size; i++) result[i] = dense[i];
        return result;
    }

    // Override this in subclasses or pass a lambda if needed
    protected int getId(T element) {
        // Example: for Artist, return element.getId();
        return -1;
    }

    public int size() { return size; }
}
