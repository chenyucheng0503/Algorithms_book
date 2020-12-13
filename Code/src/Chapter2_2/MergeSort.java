package Chapter2_2;

import algs4.In;
import algs4.StdOut;

public class MergeSort {
    // 需要辅助数组, 原地归并已经有序的 a[low, mid] & a[mid, high]
    public static void merge(Comparable[] a, int low, int high, int mid){
        // aux代表辅助数组。auxiliary
        Comparable[] aux = new Comparable[a.length];
        // 将a复制一份到aux
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
    }

    // 自顶向下归并
    public static  void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
    }

    // 自底向上归并
    public static void sortBU(Comparable[] a) {
        // 进行lgN次两两归并
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz+sz)// sz子数组大小
            for (int lo = 0; lo < N-sz; lo += sz+sz) // lo:子数组索引
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
    }

    public static void sort(Comparable[] a, int low, int high){
        // 将数组a[low..high]排序
        if (high <= low)
            return;

        int mid = low + (high - low)/2;
        sort(a, low, mid); // 将左半边排序
        sort(a, mid+1, high); // 将右半边排序
        merge(a, low, mid, high); // 归并结果
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        // 在单行中打印数
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        // 测试数组元素是否有序
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    public static void main(String[] args) {
        // 从标准输入读取字符串，将它们排序并输出
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
