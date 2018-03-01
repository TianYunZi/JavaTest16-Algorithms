package chapter02.select.practise;

import chapter02.sort.practise.Template;

import static chapter02.sort.practise.Template.exch;
import static chapter02.sort.practise.Template.less;
import static chapter02.sort.practise.Template.show;

/**
 * 选择排序.
 */
public class SelectionSort {

    /**
     * 按升序排序.
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, min, i);
        }
    }

    public static void main(String[] args) {
        Integer[] a = {1, 4, 2, 5, 9, 3, 7};
        sort(a);
        show(a);
    }
}
