package Chapter2_3;

import algs4.StdRandom;
import Chapter2_3.Quick;

/**
 * @author GrahamSa (https://github.com/chenyucheng0503)
 * @ClassName Ex2_3_17.java
 * @Description 哨兵。修改算法 2.5，去掉内循环 while 中的边界检查。
 * 由于切分元素本身就是一个哨兵（v不可能小于 a[lo] ），左侧边界的检查是多余的。
 * 要去掉另一个检查，可以在打乱数组后将数组的最大元素放在 a[length-1] 中。该元素永远不会移动（除非和相等的元素交换），可以在所有包含它的子数组中成为哨兵。
 * 注意：在处理内部子数组时，右子数组中最左侧的元素可以作为左子数组右边界的哨兵。
 * @References https://www.cnblogs.com/longjin2018/p/9860246.html
 * @createTime 2021年03月12日 15:07:00
 */

public class Ex2_3_17 {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a); // 消除对输入的依赖

        //将最大元素放到末尾
        exch(a,maxIndex(a),a.length-1);

        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);  // 切分（请见“快速排序的切分”）
        sort(a, lo, j-1);  // 将左半部分a[lo .. j-1]排序
        sort(a, j+1, hi);  // 将右半部分a[j+1 .. hi]排序
    }

    /** 去掉内部的边界检查 */
    private static int partition(Comparable[] a, int lo, int hi) {
        // 将数组切分为a[lo..i-1], a[i], a[i+1..hi]
        int i = lo, j = hi+1;  // 左右扫描指针
        Comparable v = a[lo];  // 切分元素

        while (true)
        { // 扫描左右，检查扫描是否结束并交换元素
            while (less(a[++i], v));
                //if (i == hi) break;
            while (less(v, a[--j]));
                //if (j == lo) break;
            if (i >= j)
                break;

            exch(a, i, j);
        }
        exch(a, lo, j); //将v=a[j]放入正确的位置
        return j; //a[lo..j-1] <= a[j] <= a[j+1..hi]达成
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
