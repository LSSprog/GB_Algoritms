import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyDeka<T> {
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    /*private int beginLeft;
    private int beginRight;
    private int endLeft;
    private int endRight;*/
    private int begin;
    private int end;

    public MyDeka(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("вместимость не верная: " + capacity);
        }
        list = (T[]) new Object[capacity];
    }

    public MyDeka() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void insertRight(T item) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        list[end] = item;
        end = nextIndexToRight(end);
        size ++;
    }

    public void insertLeft(T item) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        begin = nextIndexToLeft(begin);
        list[begin] = item;
        //endLeft = nextIndexToLeft(endLeft);
        size ++;
    }


    public T peekFront() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list[begin];
    }

    public T peekBehind() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list[nextIndexToLeft(end)];
    }


    public T removeLeft() {
        T temp = peekFront();
        list[begin] = null;
        begin = nextIndexToRight(begin);
        size --;
        return temp;
    }

    public T removeRight() {
        T temp = peekBehind();
        list[nextIndexToLeft(end)] = null;
        end = nextIndexToLeft(end);
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

    private int nextIndexToRight(int index) { // получение следующего индекса по кругу
        return (index + 1) % list.length;
    }

    private int nextIndexToLeft(int index) { // получение следующего индекса по кругу
        if (index ==0) {
            return list.length - 1;
        }
        return (index - 1);
    }


    @Override
    public String toString() { // можно переделать в нормальный, чтобы по очереди было видно кто за кем
        return Arrays.toString(list) + " begin: " + begin + " end: " + end;
    }
}

