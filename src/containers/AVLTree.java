package containers;

public class AVLTree<T extends Comparable<T>> {

    private class Node {
        T value;
        Node left, right;
        int height;

        Node(T val) {
            value = val;
            height = 1;
        }
    }

    private Node root;

    // height of node
    private int height(Node n) {
        return n == null ? 0 : n.height;
    }

    //balance factor -> bf
    private int getBalance(Node n) {
        return n == null ? 0 : height(n.left) - height(n.right);
    }

    // Right rotation
    private Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        return x;
    }

    // Left rotation
    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        return y;
    }

    // Insert
    public void insert(T value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node node, T value) {
        if (node == null) return new Node(value);

        int cmp = value.compareTo(node.value);

        if (cmp < 0) node.left = insertRec(node.left, value);
        else if (cmp > 0) node.right = insertRec(node.right, value);
        else return node; // duplicates not allowed

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        // Left Left
        if (balance > 1 && value.compareTo(node.left.value) < 0)
            return rotateRight(node);

        // Right Right
        if (balance < -1 && value.compareTo(node.right.value) > 0)
            return rotateLeft(node);

        // Left Right
        if (balance > 1 && value.compareTo(node.left.value) > 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Right Left
        if (balance < -1 && value.compareTo(node.right.value) < 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    // Search
    public boolean contains(T value) {
        return containsRec(root, value);
    }

    private boolean containsRec(Node node, T value) {
        if (node == null) return false;

        int cmp = value.compareTo(node.value);
        if (cmp == 0) return true;
        return cmp < 0 ? containsRec(node.left, value) : containsRec(node.right, value);
    }

    // In-order print (sorted)
    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node n) {
        if (n == null) return;
        inOrderRec(n.left);
        System.out.println(n.value);
        inOrderRec(n.right);
    }
}
