package chapter02.top.down.merge.sort;

import java.util.Arrays;

import static chapter02.sort.practise.Template.less;
import static chapter02.sort.practise.Template.show;

public class TopDownMergeSort {

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

    public static void sort(Comparable[] a, int lo, int hi) {
        // 将数组a[lo..hi]排序
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public static void main(String[] args) {
        Comparable[] arr = {1, 5, 2, 77, 11, 5, 8, 2, 0, 1, 3};
        sort(arr, 0, arr.length - 1);
        show(arr);
    }
}
