import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<T extends Comparable<T>> {
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Попытка создания массива вместимостью : " + capacity);
        }
        list = (T[]) new Comparable[capacity]; //Object вместо Compar если просто лист создаём
    }

    public MyArrayList() {
        list = (T[]) new Comparable[DEFAULT_CAPACITY];
    }

    public boolean checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("индекс за пределами листа: " + index);
        }
        return true;
    }

    public final int indexOf (T item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public void add(T item) {
        if (size >= capacity()) {
            reCapacity();
        }
        list[size] = item;
        size++;
    }

    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("индекс за пределами листа: " + index);
        }
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = item;
        size++;
    }

    public void remove(int index) {
        if (checkIndex(index)) {
            for (int i = index; i < (size - 1) ; i++) {
                list[i] = list[i + 1];
            }
            size --;
            list[size] = null;
        }
    }

    public boolean remove (T item) {
        int k = indexOf(item);
        if (k == -1) {
            return false;
        }
        remove(k);
        return true;
    }

    public T get(int index) {
        if (checkIndex(index)) {
            return list[index];
        } else {
            return null;
        }
    }

    public void set (int index, T item) {
        if (checkIndex(index)) {
            list[index] = item;
        }
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(list[i]).append(", ");
        }
        if (size > 0) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }

        private boolean less(T item1, T item2) {
            return (item1.compareTo(item2) < 0);
        }

        public void swap(int index1, int index2) {
            if (checkIndex(index1) && checkIndex(index2)) {
                T temp = list[index1];
                list[index1] = list[index2];
                list[index2] = temp;
            }
        }

    public void selectionSort() {
        int iMin;
        for (int i = 0; i < (size - 1); i++) {
            iMin = i;
            for (int j = i + 1; j < size; j++) {
                 if (less(list[j], list[iMin])) {
                     iMin = j;
                 }
            }
            swap(i, iMin);
        }
    }

    public void insertionSort() {
        T key;
        for (int i = 1; i < size; i++) {
            key = list[i];
            int j = i;
            while (j > 0 && less(key, list[j - 1])) {
                list[j] = list[j - 1];
                j--;
            }
            list[j] = key;
        }
    }

    public void bubbleSort() {
        boolean isSwap;
        for (int i = (size - 1); i > 0; i--) {
            isSwap = false;
            for (int j = 0; j < i; j++) {
                if (less(list[j + 1], list[j] )) {
                    swap(j, (j + 1));
                    isSwap = true;
                }
            }
            if (!isSwap) {
                System.out.printf("сортировкак окончена, осталось %d проходов \n", i);
                break;
            }
        }
    }

    public int capacity() {
        return list.length;
    }

    private void reCapacity() {
        int newCapacity = size * 2;
        T[] temp = (T[]) new Comparable[newCapacity];
        temp = Arrays.copyOf(list, newCapacity);
        list = temp;
    }

    public void selectionSort(Comparator<T> comparator) {
        int iMin;
        for (int i = 0; i < size - 1; i++) {
            iMin = i;
            for (int j = i + 1; j < size; j++) {
                if (comparator.compare(list[j], list[iMin]) < 0) {
                    iMin = j;
                }
            }
            swap(i, iMin);
        }
    }

    public void insertionSort(Comparator<T> comparator) {
        T key;
        for (int i = 1; i < size; i++) {
            key = list[i];
            int j = i;
            while (j > 0 && (comparator.compare(key, list[j - 1]) < 0)) {
                list[j] = list[j - 1];
                j--;
            }
            list[j] = key;
        }
    }

    public void bubbleSort(Comparator<T> comparator) {
        boolean isSwap;
        for (int i = (size - 1); i > 0; i--) {
            isSwap = false;
            for (int j = 0; j < i; j++) {
                if (comparator.compare(list[j + 1], list[j] ) < 0) {
                    swap(j, (j + 1));
                    isSwap = true;
                }
            }
            if (!isSwap) {
                System.out.printf("сортировкак окончена, осталось %d проходов \n", i);
                break;
            }
        }
    }

}
