import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class MyTwoSidedLinkedList<T> implements Iterable<T>{
    private NodeTwoSide first;
    private NodeTwoSide last;
    private int size;

    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    public ListIterator<T> listIterator() {
        return new ListIter();
    }

    public MyTwoSidedLinkedList() {
        this.first = null;
        this.last = null;
    }

    private class Iter implements Iterator<T> {
        NodeTwoSide current = new NodeTwoSide(null,first); //некий указатель на первую ячейку
        @Override
        public boolean hasNext() {
            return current.getNext() != null;
        }

        @Override
        public T next() {
            current = current.getNext();
            return (T) current.getValue();
        }

        @Override
        public void remove() { //java пишет, что remove должен быть void
            //T tempNode = (T) current.getValue();
            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
            size--;
            //return tempNode;
        }


    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void insertFirst(T item) {
        NodeTwoSide newNode = new NodeTwoSide(item);
        newNode.setNext(first);
        if (isEmpty()) {
            last = newNode;
        } else {
            first.setPrev(newNode);
        }
        first = newNode;
        size++;
    }

    public void insertLast(T item) {
        NodeTwoSide newNode = new NodeTwoSide(item);
        if (isEmpty()) {
            first = newNode;
        } else {
            newNode.setPrev(last);
            last.setNext(newNode);
        }
        last = newNode;
        size++;
    }

    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (T) first.getValue();
    }

    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (T) last.getValue();
    }

    public T removeFirst() {
        T oldNode = getFirst();
        first = first.getNext();
        if (isEmpty()) {
            last = null;
        } else {
            first.setPrev(null);
        }
        size--;
        return oldNode;
    }

    public T removeLast() {
        T oldNode = getLast();
        if (last.getPrev() != null) {
            last.getPrev().setNext(null);
        } else {
            first = null;
        }
        last = last.getPrev();
        size--;
        return oldNode;
    }

    public final int indexOf(T item) {
        NodeTwoSide current = first;
        int index = 0;
        while (current != null) {
            if (current.getValue().equals(item)) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    public boolean contains(T item) {
        return indexOf(item) > -1;
    }

    public void insert(int index, T item) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }
        if (index == 0) {
            insertFirst(item);
        }
        if (index == size) {
            insertLast(item);
        }
        NodeTwoSide current = first;
        int i = 0;
        while (i < (index - 1)) {
            current = current.getNext();
            i++;
        }
        NodeTwoSide newNode = new NodeTwoSide(item);
        newNode.setPrev(current);
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        newNode.getNext().setPrev(newNode);
        size++;

    }

    public T remove (int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }
        if (index == 0) {
            removeFirst();
        }
        if (index == size) {
            removeLast();
        }
        NodeTwoSide current = first;
        int i = 0;
        while (i < index) {
            current = current.getNext();
            i++;
        }
        T tempNode = (T) current.getValue();
        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
        size--;
        return tempNode;
    }

    public boolean remove(T item) {
        if (isEmpty()) {
            return false;
        }
        if (first.getValue().equals(item)) {
            removeFirst();
            return true;
        }
        NodeTwoSide current = first;
        while ((current != null) && (!current.getValue().equals(item))) {
            current = current.getNext();
        }
        if (current == null) {
            return false;
        }
        if (current == last) {
             removeLast();
             return true;
        }
        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
        size--;
        return true;
    }

    @Override
    public String toString() {
        NodeTwoSide current = first;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.getValue() + ", ");
            current = current.getNext();
        }
        if (isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }

    private class ListIter implements ListIterator<T> {

        NodeTwoSide current = new NodeTwoSide(null, first); //некий указатель на первую ячейку
        int index = -1;

        @Override
        public boolean hasNext() {
            return current.getNext() != null;
        }

        @Override
        public T next() {
            current = current.getNext();
            index++;
            return (T) current.getValue();
        }

        @Override
        public boolean hasPrevious() {
            return current.getPrev() != null;
        }

        @Override
        public T previous() {
            current = current.getPrev();
            index--;
            return (T) current.getValue();
        }

        @Override
        public int nextIndex() {
            if (hasNext()) {
            return (index + 1);
            }
            return -1;
        }

        @Override
        public int previousIndex() {
            if (hasPrevious()) {
                return (index - 1);
            }
            return -1;
        }

        @Override
        public void remove() {
            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
            size--;
            index--;
        }

        @Override
        public void set(T item) {
            //NodeTwoSide<T> newNode = new NodeTwoSide<>(item);
            //insertLast(item);
            current.setValue(item);
        }

        @Override
        public void add(T item) {
            insert(index+1, item);
        }
    }
}
