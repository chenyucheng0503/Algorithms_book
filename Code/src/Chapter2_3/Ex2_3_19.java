package Chapter2_3;

import algs4.*;

/**
 * @author GrahamSa (https://github.com/chenyucheng0503)
 * @ClassName Ex2_3_19.java
 * @Description 五取样切分。实现一种基于随机抽取子数组中 5 个元素并取中位数进行切分的快速排序。
 * 将取样元素放在数组的一侧以保证只有中位数元素参与了切分。
 * 运行双倍测试来确定这项改动的效果，并和标准的快速排序以及三取样切分的快速排序（请见上一道练习）进行比较。
 * 附加题：找到一种对于任意输入都只需要少于7次比较的五取样算法。
 * @References https://www.cnblogs.com/longjin2018/p/9860255.html
 * @createTime 2021年03月12日 19:24:00
 */

public class Ex2_3_19 {
    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    /** 因为不考虑重复主键，所以采用 partition */
    public static void sort(Comparable[] a, int lo, int hi){
        if (hi <= lo)
            return;

        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        // 将数组切分为a[lo..i-1], a[i], a[i+1..hi]
        int i = lo, j = hi+1;  // 左右扫描指针
        int midIndex = FiveMidIndex(a, lo, hi);  //返回中位数的索引
        Comparable v = a[midIndex];  // 切分元素

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

    /** 返回五个随机子数的索引 */
    private static int FiveMidIndex(Comparable[] a, int lo, int hi){
        // 数组长度不足5时，取最小值为索引
        if(hi-lo < 4)
            return lo;

        Integer[] b = new Integer[5];

        // 数组长度为5时
        if (hi-lo == 4){
            for (int i = 0; i < 4; i++) {
                b[i] = lo + i;
            }
        }
        // 数组长度大于5，因为没有要求不重复，所以直接五个随机数就好，不需要考虑重复问题
        else{
            for (int i = 0; i < 4; i++) {
                b[i] = StdRandom.uniform(lo, hi+1);
            }
        }

        //将a[b[i]]排序,这里采用插入排序
        for (int i = 0; i < 4; i++) {
            for (int j = i; j > 0 && less(a[b[j]], a[b[j-1]]); j--) {
                exch(b, j, j-1);
            }
        }
        return b[2];
    }

    /** 普通的辅助函数 */
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
