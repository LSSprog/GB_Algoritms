public class MyStack<T> {

    MyTwoSidedLinkedList<T> stack = new MyTwoSidedLinkedList<>();

    public T peek() {
        return stack.getFirst();
    }

    public T pop() {
        return stack.removeFirst();
    }

    public void push(T item) {
        stack.insertFirst(item);
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}
