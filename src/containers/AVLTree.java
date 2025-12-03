package containers;

import java.util.ArrayList;
import java.util.List;

public class AVLTree<K extends Comparable<K>, V> {

    private class Node {
        K key;
        V value;
        Node left, right;
        int height = 1;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    //compute size
    private int size(Node n) {
        return n == null ? 0 : n.size;
    }

    private Node root;

    // ----------------- Utility -----------------

    private int height(Node n) {
        return n == null ? 0 : n.height;
    }

    private int balance(Node n) {
        return n == null ? 0 : height(n.left) - height(n.right);
    }

    // Rotate Right
    private Node rotateRight(Node y) {
        Node x = y.left;
        Node t2 = x.right;

        x.right = y;
        y.left = t2;

        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        return x;
    }

    // Rotate Left
    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node t2 = y.left;

        y.left = x;
        x.right = t2;

        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        return y;
    }

    // ----------------- Insert (put) -----------------

    public void put(K key, V value) {
        root = insert(root, key, value);
    }

    private Node insert(Node node, K key, V value) {
        if (node == null) return new Node(key, value);

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            node.left = insert(node.left, key, value);
        } else if (cmp > 0) {
            node.right = insert(node.right, key, value);
        } else {
            node.value = value; // replace existing
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int bf = balance(node);

        // Left Left
        if (bf > 1 && key.compareTo(node.left.key) < 0)
            return rotateRight(node);

        // Right Right
        if (bf < -1 && key.compareTo(node.right.key) > 0)
            return rotateLeft(node);

        // Left Right
        if (bf > 1 && key.compareTo(node.left.key) > 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Right Left
        if (bf < -1 && key.compareTo(node.right.key) < 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    // ----------------- Search (get) -----------------

    public V get(K key) {
        Node node = search(root, key);
        return node == null ? null : node.value;
    }

    private Node search(Node node, K key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);

        if (cmp == 0) return node;
        return cmp < 0 ? search(node.left, key) : search(node.right, key);
    }

    public boolean containsKey(K key) {
        return search(root, key) != null;
    }

    // ----------------- Delete (remove) -----------------

    public void remove(K key) {
        root = delete(root, key);
    }

    private Node delete(Node node, K key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            // node with 1 child or 0 child
            if (node.left == null || node.right == null) {
                return (node.left != null) ? node.left : node.right;
            }

            // node with 2 children → get inorder successor
            Node successor = minValueNode(node.right);
            node.key = successor.key;
            node.value = successor.value;

            node.right = delete(node.right, successor.key);
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int bf = balance(node);

        // Left Left
        if (bf > 1 && balance(node.left) >= 0)
            return rotateRight(node);

        // Left Right
        if (bf > 1 && balance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Right Right
        if (bf < -1 && balance(node.right) <= 0)
            return rotateLeft(node);

        // Right Left
        if (bf < -1 && balance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    // ----------------- Traversal -----------------

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node n) {
        if (n == null) return;
        inOrder(n.left);
        System.out.println(n.key + " => " + n.value);
        inOrder(n.right);
    }

    //just to get things to print
    public List<V> toListInOrder() {
        List<V> list = new ArrayList<>();
        collect(root, list);
        return list;
    }

    //inorder listing so that everything is smaller -> greater
    private void collect(Node n, List<V> list) {
        if (n == null) return;
        collect(n.left, list);
        list.add(n.value);
        collect(n.right, list);
    }

}
