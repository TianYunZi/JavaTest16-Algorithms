package chapter.insert.practise;

import static chapter02.sort.practise.Template.exch;
import static chapter02.sort.practise.Template.less;
import static chapter02.sort.practise.Template.show;

/**
 * 插入排序
 */
public class InsertionSelect {

    /**
     * 升序.
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arrs = {2, 6, 3, 7, 4, 9, 1, 6};
        sort(arrs);
        show(arrs);
    }
}
