package chapter03.binary.search.rotated.sorted.array;

/**
 * 二分查找(基于有序数组)
 *
 * @param <Key>
 * @param <Value>
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {

    private Key[] keys;

    private Value[] values;

    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public Boolean isEmpty() {
        return N == 0;
    }

    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return values[i];
        } else {
            return null;
        }
    }

    /**
     * 二分查找核心.
     *
     * @param key
     * @return
     */
    private int rank(Key key) {
        int lo = 0;
        int hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public void put(Key key, Value value) {
        // 查找键，找到则更新值，否则创建新的元素.
        int i = rank(key);

        if (i < N && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }

        if (N == keys.length) {
            resize(2 * keys.length);
        }

        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    public void delete(Key key) {
        if (isEmpty()) {
            return;
        }

        int i = rank(key);

        // key不在表中
        if (i < 0 || i >= N || keys[i].compareTo(key) != 0) {
            return;
        }

        for (int j = i; j < N - 1; j++) {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }
        N--;
        keys[N - 1] = null;
        values[N - 1] = null;

        if (N > 0 && N <= keys.length / 4) {
            resize(keys.length / 2);
        }
    }

    private void resize(int capacity) {
        assert capacity >= N;
        Key[] tempKeys = (Key[]) new Comparable[capacity];
        Value[] tempValues = (Value[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            tempKeys[i] = keys[i];
            tempValues[i] = values[i];
        }
        keys = tempKeys;
        values = tempValues;
    }

    public static void main(String[] args) {
        BinarySearchST<Integer, String> binarySearchST = new BinarySearchST<>(1);
        binarySearchST.put(1, "aaa");
        binarySearchST.put(1, "aaa1");
        binarySearchST.put(1, "aaa2");
        binarySearchST.put(2, "aaa3");
        binarySearchST.put(2, "aaa4");
        binarySearchST.put(3, "aaa5");
        System.out.println(binarySearchST.size());
        System.out.println(binarySearchST.get(3));
        binarySearchST.delete(3);
        System.out.println(binarySearchST.size());
        System.out.println(binarySearchST.get(3));
    }
}
