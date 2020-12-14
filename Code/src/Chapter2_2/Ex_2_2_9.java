package Chapter2_2;

/**
 * @author GrahamSa (https://github.com/chenyucheng0503)
 * @ClassName Ex_2_2_9.java
 * @Description 在库函数中使用 aux[] 这样的静态数组是不妥当的，因为可能会有多个程序同时使用这个类。实现一个不用静态数组的 Merge 类，但也不要 将 aux[] 变为 merge() 的局部变量（请见本节的答疑部分）。
 * @createTime 2020年12月13日 21:24:00
 */

public class Ex_2_2_9 {
    /** 构造函数 一般最好加上*/
    private Ex_2_2_9() {}

    /** 归并操作 */
    public static void merge(Comparable[] a, int low, int high, int mid, Comparable[] aux){
        // 断言初始数组有序
        assert isSorted(a, low, mid);
        assert isSorted(a, mid+1, high);

        // 将a复制一份到aux, 由于aux的长度肯定大于a，所以不用考虑，而且每次merge只用初始化前 a.length 的内容即可
        for (int i = low; i <= high; i++) {
            aux[i] = a[i];
        }

        // 记录两个数组的游标
        int m = low;
        int n = mid + 1;
        for (int i = low; i <= high; i++) {
            if (m > mid){
                a[i] = aux[n];
                n += 1;
            }
            else if (n > high){
                a[i] = aux[m];
                m += 1;
            }
            else if (aux[m].compareTo(aux[n]) < 0) {
                a[i] = aux[m];
                m += 1;
            }
            else{
                a[i] = aux[n];
                n += 1;
            }
        }

        // 简便写法（书中代码）
        /*for (int i = low; i <= high; i++) {
            if (m > mid){
                a[i] = aux[n++];
            }
            else if (n > high){
                a[i] = aux[m++];
            }
            else if (less(aux[m], aux[n])) {
                a[i] = aux[m++];
            }
            else{
                a[i] = aux[n++];
            }
        }*/

        // 后置条件
        assert isSorted(a, low, high);
    }

    /** 自顶向下归并 */
    public static  void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        sort(a, 0, a.length - 1, aux);
        // 后置条件
        assert isSorted(a);
    }

    /** 自顶向下归并 重载 */
    public static void sort(Comparable[] a, int low, int high, Comparable[] aux){
        // 将数组a[low..high]排序
        if (high <= low)
            return;

        int mid = low + (high - low)/2;

        sort(a, low, mid, aux); // 将左半边排序
        sort(a, mid+1, high, aux); // 将右半边排序
        merge(a, low, mid, high, aux); // 归并结果
    }

    /** 自底向上归并 */
    public static void sortBU(Comparable[] a) {
        // 进行lgN次两两归并
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz+sz)// sz子数组大小
            for (int lo = 0; lo < N-sz; lo += sz+sz) // lo:子数组索引
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1), aux);
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

}
