public class NodeTwoSide<T> {
    private T value;
    private NodeTwoSide next;
    private NodeTwoSide prev;

    public NodeTwoSide(T value) {
        this.value = value;
    }

    public NodeTwoSide(T value, NodeTwoSide next) {
        this.value = value;
        this.next = next;
    }

    public NodeTwoSide(T value, NodeTwoSide next, NodeTwoSide prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public NodeTwoSide getNext() {
        return next;
    }

    public void setNext(NodeTwoSide next) {
        this.next = next;
    }

    public NodeTwoSide getPrev() {
        return prev;
    }

    public void setPrev(NodeTwoSide prev) {
        this.prev = prev;
    }
}
