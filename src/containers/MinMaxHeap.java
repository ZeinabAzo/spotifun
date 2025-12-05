package containers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.lang.Math;

public class MinMaxHeap<T> {
    private List<T> heap;
    private Comparator<T> comp;

    public MinMaxHeap(Comparator<T> comp) {
        heap = new ArrayList<>();
        heap.add(null); // 1-indexed
        this.comp = comp;
    }

    private int parent(int i) { return i / 2; }
    private int left(int i) { return 2 * i; }
    private int right(int i) { return 2 * i + 1; }
    private int grandparent(int i) { return i / 4; }
    private boolean isMinLevel(int i) { return (int)(Math.log(i)/Math.log(2)) % 2 == 0; }
    private void swap(int i, int j) {
        T tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }
    private int size() { return heap.size() - 1; }
    private int compare(T a, T b) { return comp.compare(a, b); }

    // ----------------- Insert -----------------
    public void insert(T x) {
        heap.add(x);
        int i = size();
        if (isMinLevel(i)) {
            if (i > 1 && compare(heap.get(i), heap.get(parent(i))) > 0) {
                swap(i, parent(i));
                bubbleUpMax(parent(i));
            } else {
                bubbleUpMin(i);
            }
        } else {
            if (i > 1 && compare(heap.get(i), heap.get(parent(i))) < 0) {
                swap(i, parent(i));
                bubbleUpMin(parent(i));
            } else {
                bubbleUpMax(i);
            }
        }
    }

    private void bubbleUpMin(int i) {
        while (i > 3 && compare(heap.get(i), heap.get(grandparent(i))) < 0) {
            swap(i, grandparent(i));
            i = grandparent(i);
        }
    }

    private void bubbleUpMax(int i) {
        while (i > 3 && compare(heap.get(i), heap.get(grandparent(i))) > 0) {
            swap(i, grandparent(i));
            i = grandparent(i);
        }
    }

    // ----------------- Get Min/Max -----------------
    public T getMin() {
        return size() >= 1 ? heap.get(1) : null;
    }

    public T getMax() {
        if (size() == 0) return null;
        if (size() == 1) return heap.get(1);
        if (size() == 2) return heap.get(2);
        return compare(heap.get(2), heap.get(3)) > 0 ? heap.get(2) : heap.get(3);
    }

    // ----------------- Delete Min/Max -----------------
    public T deleteMin() {
        if (size() == 0) return null;
        T min = heap.get(1);
        heap.set(1, heap.get(size()));
        heap.remove(size());
        if (size() >= 1) pushDownMin(1);
        return min;
    }

    public T deleteMax() {
        if (size() == 0) return null;
        if (size() == 1) return heap.remove(1);
        int idx = 2;
        if (size() > 2 && compare(heap.get(3), heap.get(2)) > 0) idx = 3;
        T max = heap.get(idx);
        heap.set(idx, heap.get(size()));
        heap.remove(size());
        pushDownMax(idx);
        return max;
    }

    // ----------------- Push Down -----------------
    private List<Integer> childrenAndGrandchildren(int i) {
        List<Integer> cg = new ArrayList<>();
        for (int c : new int[]{left(i), right(i)}) {
            if (c <= size()) {
                cg.add(c);
                for (int g : new int[]{left(c), right(c)}) {
                    if (g <= size()) cg.add(g);
                }
            }
        }
        return cg;
    }

    private void pushDownMin(int i) {
        List<Integer> cg = childrenAndGrandchildren(i);
        if (cg.isEmpty()) return;
        int m = cg.get(0);
        for (int idx : cg) if (compare(heap.get(idx), heap.get(m)) < 0) m = idx;

        if (m >= left(left(i))) { // grandchild
            if (compare(heap.get(m), heap.get(i)) < 0) {
                swap(i, m);
                int p = parent(m);
                if (compare(heap.get(m), heap.get(p)) > 0) swap(m, p);
                pushDownMin(m);
            }
        } else {
            if (compare(heap.get(m), heap.get(i)) < 0) swap(i, m);
        }
    }

    private void pushDownMax(int i) {
        List<Integer> cg = childrenAndGrandchildren(i);
        if (cg.isEmpty()) return;
        int m = cg.get(0);
        for (int idx : cg) if (compare(heap.get(idx), heap.get(m)) > 0) m = idx;

        if (m >= left(left(i))) { // grandchild
            if (compare(heap.get(m), heap.get(i)) > 0) {
                swap(i, m);
                int p = parent(m);
                if (compare(heap.get(m), heap.get(p)) < 0) swap(m, p);
                pushDownMax(m);
            }
        } else {
            if (compare(heap.get(m), heap.get(i)) > 0) swap(i, m);
        }
    }

    // ----------------- Search / Delete specific -----------------
    public int search(T x) {
        for (int i = 1; i <= size(); i++) {
            if (heap.get(i).equals(x)) return i;
        }
        return -1;
    }

    public boolean delete(T x) {
        int i = search(x);
        if (i == -1) return false;
        heap.set(i, heap.get(size()));
        heap.remove(size());
        if (i <= size()) {
            if (isMinLevel(i)) {
                pushDownMin(i);
                bubbleUpMin(i);
            } else {
                pushDownMax(i);
                bubbleUpMax(i);
            }
        }
        return true;
    }

    // ----------------- Print Heap -----------------
    public void printHeap() {
        for (int i = 1; i <= size(); i++) System.out.print(heap.get(i) + " ");
        System.out.println();
    }

}
