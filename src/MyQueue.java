import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyQueue<T> {
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    private int begin;
    private int end;

    public MyQueue(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("вместимость не верная: " + capacity);
        }
        list = (T[]) new Object[capacity];
    }

    public MyQueue() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void insert(T item) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        list[end] = item;
        end = nextIndex(end);
        size ++;
    }

    public T peekFront() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list[begin];
    }

    public T remove() {
        T temp = peekFront();
        list[begin] = null;
        begin = nextIndex(begin);
        size --;
        return temp;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == list.length;
    }

    public int size() {
        return size;
    }

    private int nextIndex(int index) { // получение следующего индекса по кругу
        return (index + 1) % list.length;
    }

    @Override
    public String toString() { // можно переделать в нормальный, чтобы по очереди было видно кто за кем
        return Arrays.toString(list) + " begin: " + begin + " end: " + end;
    }
}
