package Chapter2_3;

import algs4.*;

/**
 * @author GrahamSa (https://github.com/chenyucheng0503)
 * @ClassName Ex2_3_18.java
 * @Description 三取样切分。为快速排序实现正文所述的三取样切分（参见 2.3.3.2 节）。运行双倍测试来确认这项改动的效果
 * @References https://algs4.cs.princeton.edu/23quicksort/Quick3way.java.html
 * @createTime 2021年03月12日 15:54:00
 */

public class Ex2_3_18 {
    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);

        //将最大元素放到末尾
        exch(a,maxIndex(a),a.length-1);

        assert isSorted(a);
    }

    private static void sort(Comparable[] a, int lo, int hi){
        if (hi <= lo)
            return;

        int lt=lo, gt=hi;
        int i = lo + 1;
        Comparable v = a[lo];

        while(i <= gt){
            int cmp = a[i].compareTo(v);
            if (cmp < 0)
                exch(a, lt++, i++);
            else if (cmp > 0)
                exch(a, i, gt--);
            else
                i++;
        }

        sort(a, lo, lt-1);
        sort(a, gt+1, hi);
    }

    /** maxIndex 找到最大值,用于替换a[length-1] */
    public static int maxIndex(Comparable[] a)
    {
        int max=0;
        for(int i=1; i<a.length; i++)
        {
            if(less(a[max], a[i]))
                max=i;
        }
        return max;
    }

    /** 下列都是跟Quick一致 */
    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        if (v == w) return false;   // optimization when reference equals
        return v.compareTo(w) < 0;
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    /** 断言是否有序 */
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }
    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.printf(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        // 随机生成100个 1-100 的整数
        Comparable[] a = new Comparable[100];
        for (int i = 0; i < a.length; i++) {
            a[i] = 1 + (int)(Math.random() * 100);
        }

        // 将 a 排序
        sort(a);
        show(a);
    }
}
