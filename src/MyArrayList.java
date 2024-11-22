public class MyArrayList {
    private static final int DEFAULT_CAPACITY = 10;
    private int[] items;
    private int count = 0;

    public MyArrayList(int length) {
        items = new int[length];
    }

    public MyArrayList() {
        items = new int[DEFAULT_CAPACITY];
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }

    public void add(int item) {
        if (items.length == count) {
            int[] newItems = new int[count * 2];
            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }

        items[count++] = item;
    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++) {
            if (items[i] == item) {
                return i;
            }
        }

        return -1;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }

        for (int i = index; i < count; i++) {
            items[i] = items[i + 1];
        }

        count--;
    }

    public void insertAt(int item, int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Index out of bounds");
        }

        if (items.length == count) {
            int[] newItems = new int[count * 2];
            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }

        for (int i = count - 1; i >= index; i--) {
            items[i + 1] = items[i];
        }

        items[index] = item;
        count++;
    }

    public java.lang.Integer min() {
        if (count < 1) {
            return null;
        }

        int min = items[0];
        for (int i = 0; i < count; i++) {
            if (items[i] < min) {
                min = items[i];
            }
        }
        return min;
    }

    public java.lang.Integer max() {
        if (count < 1) {
            return null;
        }

        int max = items[0];
        for (int i = 0; i < count; i++) {
            if (items[i] > max) {
                max = items[i];
            }
        }
        return max;
    }
}
