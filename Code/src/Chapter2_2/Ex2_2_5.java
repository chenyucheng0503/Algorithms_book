package Chapter2_2;

/**
 * @author GrahamSa (https://github.com/chenyucheng0503)
 * @ClassName Ex_2_2_5.java
 * @Description 当输入数组的大小 N =39 时，给出自顶向下和自底向上的归并排序中各次归并子数组的大小及顺序。
 * @createTime 2020年12月13日 21:18:00
 */

public class Ex2_2_5 {
    // 输出子数组的大小
    private static void merge(int lo, int mid, int hi) {
        System.out.print(hi - lo + 1);
        System.out.print(" ");
    }

    // 自上而下
    private static void topDownMergesort(int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        topDownMergesort(lo, mid);
        topDownMergesort(mid + 1, hi);
        merge(lo, mid, hi);
    }

    public static void topDownMergesort(Comparable[] a) {
        topDownMergesort(0, a.length-1);
    }

    // 自下而上
    public static void bottomUpMergesort(Comparable[] a) {
        int n = a.length;
        for (int len = 1; len < n; len *= 2) {
            for (int lo = 0; lo < n-len; lo += len+len) {
                int mid  = lo+len-1;
                int hi = Math.min(lo+len+len-1, n-1);
                merge(lo, mid, hi);
            }
        }
    }

    public static void main(String[] args) {
        int n = 39;
        String[] a = new String[n];
        Ex2_2_5.topDownMergesort(a);
        System.out.println();
        Ex2_2_5.bottomUpMergesort(a);
        System.out.println();
    }
}
