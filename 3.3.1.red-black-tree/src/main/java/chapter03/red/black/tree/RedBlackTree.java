package chapter03.red.black.tree;

/**
 * 红黑树RedBlackBST.
 */
public class RedBlackTree<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;

    private static final boolean BLACK = false;

    private Node root; // 根结点

    private class Node {

        private Key key; // 键

        private Value value; // 相关联的值

        private Node left, right; // 左右子树

        private int N; // 这颗子树中的结点总数

        private boolean color; // 由其父结点指向它的链接的颜色

        public Node(Key key, Value value, int n, boolean color) {
            this.key = key;
            this.value = value;
            N = n;
            this.color = color;
        }
    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    /**
     * 左旋转.
     *
     * @param h
     * @return
     */
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    /**
     * 右旋转.
     *
     * @param h
     * @return
     */
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    /**
     * 颜色转换.
     *
     * @param h
     */
    private void flipColors(Node h) {
        h.color = RED; // 根结点一定是黑色
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    /**
     * 插入操作,若key存在则更新，不存在则创建结点.
     *
     * @param h
     * @param key
     * @param value
     * @return
     */
    private Node put(Node h, Key key, Value value) {
        if (h == null) {
            return new Node(key, value, 1, RED);
        }
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = put(h.left, key, value);
        } else if (cmp > 0) {
            h.right = put(h.right, key, value);
        } else {
            h.value = value;
        }
        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }
        h.N = 1 + size(h.left) + size(h.right);
        return h;
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.N;
        }
    }
}
