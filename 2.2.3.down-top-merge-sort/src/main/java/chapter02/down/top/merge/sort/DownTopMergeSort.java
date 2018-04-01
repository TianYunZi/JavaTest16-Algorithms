package chapter02.down.top.merge.sort;

import java.util.Arrays;

import static chapter02.sort.practise.Template.less;
import static chapter02.sort.practise.Template.show;

public class DownTopMergeSort {

    private static Comparable[] aux;

    public static void merge(Comparable[] a, int lo, int mid, int hi) {

        // 将a[lo..mid]和a[mid + 1 .. hi]归并
        int i = lo, j = mid + 1;
        aux = Arrays.copyOf(a, a.length);

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }

    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int size = 1; size < N; size = size + size) {
            for (int lo = 0; lo < N - size; lo += size + size) { // size子数组大小
                merge(a, lo, lo + size - 1, Math.min(lo + size + size - 1, N - 1));
            }
        }
    }

    public static void main(String[] args) {
        Comparable[] arr = {1, 5, 2, 77, 11, 5, 8, 2, 0, 1, 3};
        sort(arr);
        show(arr);
    }
}
