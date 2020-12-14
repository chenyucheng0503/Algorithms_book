package Chapter2_2;

/**
 * @author GrahamSa (https://github.com/chenyucheng0503)
 * @ClassName Ex_2_2_10.java
 * @Description 快速归并。实现一个 merge() 方法，按降序将 a[] 的后半部分复制到 aux[] ，然后将其归并回 a[] 中。这样就可以去掉内循环中检测某半边是否用尽的代码
 * 注意：这样的排序产生的结果是 不稳定的（请见 2.5.1.8 节）。
 * @createTime 2020年12月14日 08:46:00
 */

public class Ex2_2_10 {
    /** 构造函数 一般最好加上*/
    private Ex2_2_10() {}

    /** 快速归并操作 */
    private static void quickMerge(Comparable[] a, int low, int mid, int high, Comparable[] aux){
        // 断言初始数组有序
        assert isSorted(a, low, mid);
        assert isSorted(a, mid+1, high);

        // 前半部分复制到aux
        for (int i = low; i <= mid; i++) {
            aux[i] = a[i];
        }

        // 后半部分倒序复制到aux
        for (int i = mid+1; i <= high; i++) {
            aux[i] = a[high + mid+1 - i];
        }

        int m = low, n = high;
        // 开始排序，无需比较代码
        for (int i = low; i <= high; i++) {
            if(less(aux[n], aux[m]))
                a[i] = aux[n--];
            else
                a[i] = aux[m++];
        }

        // 后置条件
        assert isSorted(a, low, high);
    }

    /** 自顶向下归并 */
    public static  void quickMergeSort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        quickMergeSort(a, 0, a.length - 1, aux);
        // 后置条件
        assert isSorted(a);
    }

    /** 自顶向下归并 重载 */
    public static void quickMergeSort(Comparable[] a, int low, int high, Comparable[] aux){
        // 将数组a[low..high]排序
        if (high <= low)
            return;

        int mid = low + (high - low)/2;

        quickMergeSort(a, low, mid, aux); // 将左半边排序
        quickMergeSort(a, mid+1, high, aux); // 将右半边排序
        quickMerge(a, low, mid, high, aux); // 快速归并结果
    }

    /** less 判断*/
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /** 判断有序 */
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    public static void main(String[] args) {
        Comparable[] a = {2,6,8,4,1,7,9,10,3,5};
        quickMergeSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.printf(a[i].toString() + ",");
        }
    }
}
