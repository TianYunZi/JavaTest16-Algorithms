package chapter02.three.dimensional.segmentation.quick.sort;

import static chapter02.sort.practise.Template.exch;
import static chapter02.sort.practise.Template.less;
import static chapter02.sort.practise.Template.show;

/**
 * 三向切分快速排序
 */
public class ThreeDimensionalSegmentationQuickSort {

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int lt = lo, i = lo + 1, gt = hi;
        var v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                exch(a, lt++, i++);
            } else if (cmp > 0) {
                exch(a, i, gt--);
            } else {
                i++;
            } // 现在a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]成立
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    public static void main(String[] args) {
        Comparable[] arr = {2, 6, 1, 5, 3, 99, 54, 8, 12, 5, 5, 5};
        sort(arr);
        show(arr);
    }
}
