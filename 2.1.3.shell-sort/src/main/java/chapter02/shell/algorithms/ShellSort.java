package chapter02.shell.algorithms;

import static chapter02.sort.practise.Template.exch;
import static chapter02.sort.practise.Template.less;
import static chapter02.sort.practise.Template.show;

/**
 * 希尔排序.
 */
public class ShellSort {

    /**
     * 升序排序.
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        int h = 1;
        while (h < a.length / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            //将数组变为h有序
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        Integer[] a = {9, 3, 1, 5, 56, 2, 7, 0, 13, 4, 4, 7, 2, 87, 2, 5};
        sort(a);
        show(a);
    }
}
