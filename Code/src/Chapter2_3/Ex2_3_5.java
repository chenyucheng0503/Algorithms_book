package Chapter2_3;
import algs4.*;


/**
 * @author GrahamSa (https://github.com/chenyucheng0503)
 * @ClassName Ex2_3_5.java
 * @Description 给出一段代码将已知只有两种主键值的数组排序。
 * @References https://algs4.cs.princeton.edu/23quicksort/Sort2distinct.java.html
 *             多种主键的快速排序适合用三分法的快速排序,而不是原版
 * @createTime 2021年03月12日 14:24:00
 */

public class Ex2_3_5 {
    /** sort 排序主函数 */
    public static void sort(Comparable[] a) {
        int lt = 0, gt = a.length - 1;
        int i = 0;
        while (i <= gt) {
            //cmp : 将a[i]与v(a[lt])比较
            /** 与三分排序不同的是,但是三分排序的v是不可变的,但是这里是可变的a[lt].
             * 因为只有两个主键,一次交换之后,大小就能够区分开来 */
            int cmp = a[i].compareTo(a[lt]);
            /**
             * 参考三分快速排序
             • a[i] 小于 v ，将 a[lt] 和 a[i] 交换，将 lt 和 i 加一；
             • a[i] 大于 v ，将 a[gt] 和 a[i] 交换，将 gt 减一；
             • a[i] 等于 v ，将 i 加一。
             */
            if (cmp < 0)
                exch(a, lt++, i++);
            else if (cmp > 0)
                exch(a, i, gt--);
            else
                i++;
        }
    }

    /** exch 交换a[i]和a[j] */
    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    /** show  */
    private static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.printf(a[i] + " ");
        }
    }

    /** 主函数 */
    public static void main(String[] args) {
        // 随机生成100个 1-2 的整数
        Comparable[] a = new Comparable[100];
        for (int i = 0; i < a.length; i++) {
            a[i] = 1 + (int) (Math.random()*2);
        }

        // 排序后
        sort(a);
        show(a);
    }
}
