public class MyQueue<T> {

    MyTwoSidedLinkedList<T> queue = new MyTwoSidedLinkedList<>();

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void enqueue (T item) {
        queue.insertFirst(item);
    }

    public T dequeue (T item) {
        return queue.removeLast();
    }

    public T peekFront() {
        return queue.getLast();
    }
}
