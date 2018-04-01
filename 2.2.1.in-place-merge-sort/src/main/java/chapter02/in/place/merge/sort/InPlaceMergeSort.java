package chapter02.in.place.merge.sort;

import java.util.Arrays;

import static chapter02.sort.practise.Template.less;
import static chapter02.sort.practise.Template.show;

public class InPlaceMergeSort {

    public static void merge(Comparable[] a, int lo, int mid, int hi) {

        // 将a[lo..mid]和a[mid + 1 .. hi]归并
        int i = lo, j = mid + 1;
        Comparable[] aux = Arrays.copyOf(a, a.length);

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

    public static void main(String[] args) {
        Comparable[] arr = {1, 5, 2, 77, 11, 5, 8, 2, 0, 1, 3};
        merge(arr, 0, (arr.length - 1) / 2, arr.length - 1);
        show(arr);
    }
}
