import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack<T> {
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public MyStack(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("вместимость не верная: " + capacity);
        }
        list = (T[]) new  Object[capacity];
    }

    public MyStack() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == list.length;
    }

    public void push(T item) {
        if (isFull()) {
            reCapacity();
        }
        list[size] = item;
        size ++;
    }

    private void reCapacity() {
        T[] temp = (T[]) new Object[size * 2];
        System.arraycopy(list, 0, temp, 0, size);
        list = temp;
    }

    public int size() {
        return size;
    }

    public T pop(){
        T pop = peek();
        size --;
        list[size] = null;
        return pop;
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "list=" + Arrays.toString(list) +
                ", size=" + size +
                '}';
    }
}
