package org.priority.queue.basic;

public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq; // 基于堆的完全二叉树

    private Integer N = 0; // 存储于pq[1..N]中，pa[0]没有使用

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    private Boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = k * 2;
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    public Boolean isEmpty() {
        return N == 0;
    }

    public Integer size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1]; // 从根结点中得到最大结点元素
        exch(1, N--); // 将其和最后一个结点进行交换
        pq[N + 1] = null; // 防止对象游离
        sink(1); // 恢复堆的有序性
        return max;
    }
}

