package chapter03.sequential.search.unordered.linked.list;

public class SequentialSearch<Key, Value> {

    private int N; // 键值对数量

    private Node first; // 链表首结点

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.value;
            }
        }
        return null;
    }

    public void put(Key key, Value value) {
        //查找给定的键，找到则更新其值，否则在表中新建结点
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
        N++;
    }

    public int size() {
        return N;
    }

    public Boolean isEmpty() {
        return N == 0;
    }

    public Boolean containsKey(Key key) {
        return get(key) != null;
    }

    public void delete(Key key) {
        first = delete(first, key);
    }

    /**
     * delete key in linked list beginning at Node x
     *
     * @param x
     * @param key
     * @return
     */
    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        if (key.equals(x.key)) {
            N--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

    private class Node {

        private Key key;

        private Value value;

        private Node next;

        Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        SequentialSearch<String, String> sequentialSearch = new SequentialSearch<>();
        sequentialSearch.put("aaa", "123");
        sequentialSearch.put("aaa", "456");
        sequentialSearch.put("aaa", "789");
        System.out.println("键值对数量: " + sequentialSearch.size());
        System.out.println(sequentialSearch.get("aaa"));
        sequentialSearch.delete("aaa");
        System.out.println("键值对数量: " + sequentialSearch.size());
        System.out.println(sequentialSearch.get("aaa"));
    }
}
