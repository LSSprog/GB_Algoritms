import java.util.LinkedList;

public class ChainHashMap<Key, Value> {
    private int capacity = 3;
    private int size;
    private LinkedList<Node>[] list;

    public ChainHashMap() {
        list = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            list[i] = new LinkedList<>();
        }
    }

    private class Node  { //внутренний класс
        Key key;
        Value value;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    private void isKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key is null!!!!");
        }
    }

    public void put(Key key, Value value) {
        isKeyNotNull(key);
        int i = hash(key);
        for (Node node : list[i]) {
            if (key.equals(node.key)) {
                node.value = value;
                return;
            }
        }
        list[i].addLast(new Node(key, value));
        size++;
    }

    public Value get(Key key) {
        isKeyNotNull(key);
        int i = hash(key);
        for (Node node : list[i]) {
            if (key.equals(node.key)) {
                return node.value;
            }
        }
        return null;
    }

    public boolean contains(Key key){
        return get(key) != null;
    }

    public void delete(Key key) {
        isKeyNotNull(key);
        int i = hash(key);
        int j = 0;
        for (Node node: list[i]) {
            if (!key.equals(node.key)) {
                j++;
            } else {
                list[i].remove(j);
            }
        }
        /*for (int j = 0; j < list[i].size(); j++) {
            if (key.equals())
        }*/
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < capacity; i++) {
            for (Node node : list[i]) {
                sb.append(node.key).append(" ").append(node.value).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
