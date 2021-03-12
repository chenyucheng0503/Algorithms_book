package Chapter2_3;

import algs4.*;
/**
 * @author GrahamSa (https://github.com/chenyucheng0503)
 * @ClassName Ex2_3_16.java
 * @Description 最佳情况.编写一段程序来生成使算法 2.5 中的 sort() 方法表现最佳的数组（无重复元素）： 数组大小为 N 且不包含重复元素，每次切分后两个子数组的大小最多差 1（子数组的大小与含 有 N 个相同元素的数组的切分情况相同）。
 * （对于这道练习，我们不需要在排序开始时打乱数组。） 以下练习描述了快速排序的几个变体。 它们每个都需要分别实现， 但你也很自然地希望使用 SortCompare 进行实验来评估每种改动的效果。
 * @References https://algs4.cs.princeton.edu/23quicksort/QuickBest.java.html
 * @createTime 2021年03月12日 15:03:00
 */

public class Ex2_3_16 {
    private static void best(int[] a, int lo, int hi) {
        // 断言:  a[lo..hi] contains keys lo to hi, in order
        for (int i = lo; i <= hi; i++)
            assert a[i] == i;

        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        best(a, lo, mid-1);
        best(a, mid+1, hi);
        exch(a, lo, mid);
    }

    public static int[] best(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = i;
        best(a, 0, n-1);
        return a;
    }

    // exchange a[i] and a[j]
    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


    public static void main(String[] args) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int n = 10;
        int[] a = best(n);
        for (int i = 0; i < n; i++)
            // StdOut.println(a[i]);
            StdOut.print(alphabet.charAt(a[i]));
        StdOut.println();
    }
}
