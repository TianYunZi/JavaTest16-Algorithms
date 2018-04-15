package chapter03.linear.probing;

/**
 * 基于线性探测符号表.
 */
public class LinearProbingHashMap<Key, Value> {

    private int N; // 符号表中键值对的总数

    private int M = 16; // 线性探测表的大小

    private Key[] keys; // 键

    private Value[] values; // 值

    public LinearProbingHashMap() {
        this(16);
    }

    public LinearProbingHashMap(int cap) {
        keys = (Key[]) new Object[cap];
        values = (Value[]) new Object[cap];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) & (M - 1);
    }

    private void resize(int cap) {
        LinearProbingHashMap<Key, Value> t;
        t = new LinearProbingHashMap<>(cap);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                t.put(keys[i], values[i]);
            }
        }
        keys = t.keys;
        values = t.values;
        M = t.M;
        N = t.N;
    }

    public void put(Key key, Value value) {
        if (N >= M / 2) {
            resize(2 * M);
        }
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }
}
