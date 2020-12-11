import java.util.NoSuchElementException;

public class MyTreeMap<Key extends Comparable<Key>, Val> {

    private Node root; //первоначальный корень

    private class Node {
        Key key;
        Val value;
        Node left;
        Node right;
        int size;
        int h; // высота

        public Node(Key key, Val value) {
            this.key = key;
            this.value = value;
            this.size = 1;
            this.h = 0;
        }
    }

    private int size (Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    public int size() {
        return size(root);
    }

    public int high() {
        return high(root);
    }

    public int high (Node node) {
        if (node == null) {
            return 0;
        }
        return node.h;
        //return Math.max(high(node.left), high(node.right)) + 1;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private void isKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key should not be NULL");
        }
    }

    public void put(Key key, Val value) {
        isKeyNotNull(key);
        if (value == null) {
            //delete сделать
            return;
        }
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Val value) {
        if (node == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            node.value = value;
        } else if (cmp < 0) {
                node.left = put(node.left, key, value);
            } else {
            node.right = put(node.right, key, value);
        }
        node.size = size(node.left) + size(node.right) + 1;
        node.h = Math.max(high(node.left), high(node.right)) + 1;
        return node;
    }

    public Val get(Key key) {
        isKeyNotNull(key);
        return get(root, key);
    }

    private Val get(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node.value;
        } else if(cmp < 0) {
            return get(node.left, key);
        } else {
            return get(node.right, key);
        }
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    private Key minKey() {
        if (isEmpty()) {
            throw new NoSuchElementException("Map is empty");
        }
        return min(root).key;
    }

    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Map is empty");
        }
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        node.h = Math.max(high(node.left), high(node.right)) + 1;
        return node;
    }

    public void delete(Key key) {
        isKeyNotNull(key);
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Node temp = node;
            node = min(node.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }
        node.size = size(node.left) + size(node.right) + 1;
        node.h = Math.max(high(node.left), high(node.right)) + 1;
        return node;
    }

    @Override
    public String toString() {
        return toString(root);
    }

    private String toString(Node node) {
        if (node == null) {
            return "";
        }
        return toString(node.left) + " " + node.key + " [" + node.h + "] " + " " + toString(node.right);
    }

    public boolean isBalance() {
        return isBalance(root);
    }

    private boolean isBalance(Node node) {
        if (node == null || (node.left == null && node.right == null)) {
            return true;
        }
        if (isBalance(node.left)) {
            if (isBalance(node.right)) {
                return Math.abs(high(node.left) - high(node.right)) <= 1;
            }
        }
        return false;
    }
}
