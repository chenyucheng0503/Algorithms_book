package Chapter2_3;

import algs4.*;

/**
 * @author GrahamSa (https://github.com/chenyucheng0503)
 * @ClassName Quick.java
 * @Description 快速排序.算法2.5
 * @References
 * @createTime 2021年03月10日 20:17:00
 */

public class Quick {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a); // 消除对输入的依赖
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);  // 切分（请见“快速排序的切分”）
        sort(a, lo, j-1);  // 将左半部分a[lo .. j-1]排序
        sort(a, j+1, hi);  // 将右半部分a[j+1 .. hi]排序
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        // 将数组切分为a[lo..i-1], a[i], a[i+1..hi]
        int i = lo, j = hi+1;  // 左右扫描指针
        Comparable v = a[lo];  // 切分元素

        while (true)
        { // 扫描左右，检查扫描是否结束并交换元素
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j); //将v=a[j]放入正确的位置
        return j; //a[lo..j-1] <= a[j] <= a[j+1..hi]达成
    }

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

    public static void main(String[] args) {
        // 随机生成100个 1-100 的整数
        Comparable[] a = new Comparable[100];
        for (int i = 0; i < a.length; i++) {
            a[i] = 1 + (int)(Math.random() * 100);
        }

        // 将 a 排序
        sort(a);

        // show(a)
        for (int i = 0; i < a.length; i++){
            System.out.printf(a[i] + " ");
        }
    }
}
