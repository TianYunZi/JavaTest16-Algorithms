package chapter03.zipper.method;

import chapter03.sequential.search.unordered.linked.list.SequentialSearch;

/**
 * 基于拉链法的散列表.
 */
public class ZipperMethodHashMap<Key, Value> {

    private int N; // 键值对总数

    private int M; // 散列表的大小

    private SequentialSearch<Key, Value>[] st; // 存放链表对象的数组

    public ZipperMethodHashMap() {
        this(16);
    }

    public ZipperMethodHashMap(int m) {
        //创建M条链表
        M = m;
        st = new SequentialSearch[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearch<>();
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) & (M - 1);
    }

    public Value get(Key key) {
        return st[hash(key)].get(key);
    }

    public void put(Key key, Value value) {
        st[hash(key)].put(key, value);
    }

    public void delete(Key key) {
        st[hash(key)].delete(key);
    }

    public static void main(String[] args) {
        ZipperMethodHashMap<String, Integer> map = new ZipperMethodHashMap<>();
        map.put("123", 123);
        map.put("345", 345);
        System.out.println(map.get("123"));
        System.out.println(map.get("345"));
    }
}
