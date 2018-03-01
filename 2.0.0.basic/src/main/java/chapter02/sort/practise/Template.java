package chapter02.sort.practise;

public class Template {
    public static void sort(Comparable[] a) {
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] arrs) {
        for (Comparable a : arrs) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    /**
     * 是否是升序排列.
     *
     * @param arrs
     * @return
     */
    public static boolean isSorted(Comparable[] arrs) {
        for (int i = 0; i < arrs.length; i++) {
            if (less(arrs[i], arrs[i - 1])) {
                return false;
            }
        }
        return true;
    }
}
