public class MySortedArrayList<T extends Comparable<T>> extends MyArrayList<T> {

    @Override
    public void add(T item) {
        int i = 0;
        while (i < size() && (get(i).compareTo(item) < 0)) {
            i++;
        }
        super.add(i, item);
    }

    @Override
    public void add(int index, T item) {
        add(item);
    }

    @Override
    public void set(int index, T item) {
        throw new UnsupportedOperationException("недопустимое действие");
    }

    public int binaryFind(T item) {
        int low = 0;
        int up = size() - 1;
        int mid;
        while (low <= up) {
            mid = low + (up - low) / 2;
            int comp = item.compareTo(get(mid));
            if (comp < 0) {
                up = mid - 1;
            } else if (comp > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
