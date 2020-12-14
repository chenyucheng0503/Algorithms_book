package Chapter2_2;

/**
 * @author GrahamSa (https://github.com/chenyucheng0503)
 * @ClassName Ex_2_2_11.java
 * @Description 改进。实现 2.2.2 节所述的对归并排序的三项改进：加快小数组的排序速度，检测数组是否已经 有序以及通过在递归中交换参数来避免数组复制。
 * @createTime 2020年12月14日 09:26:00
 */

public class Ex2_2_11 {
    /** 设定low，high差为多少的时候开始采用插入排序 */
    private static final int CUTOFF = 3;

    /** 构造函数 一般最好加上*/
    private Ex2_2_11() {}

    /** 归并操作 */
    public static void merge(Comparable[] a, int low, int mid, int high, Comparable[] aux){
        // 断言初始数组有序
        assert isSorted(a, low, mid);
        assert isSorted(a, mid+1, high);

        // 将a复制一份到aux
        for (int i = low; i <= high; i++) {
            aux[i] = a[i];
        }

        // 记录两个数组的游标
        int m = low;
        int n = mid + 1;

        // 简便写法（书中代码）
        for (int i = low; i <= high; i++) {
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
        }

        // 后置条件
        assert isSorted(a, low, high);
    }

    /** 插入排序,对于小数组可以使用 */
    public static void insertSort(Comparable[] a, int low, int high){
        //将a[]升序排列
        for (int i = low; i <= high; i++)
            for (int j = i; j > low && less(a[j], a[j-1]); j--)
                exch(a, j, j-1);

/*      // 判断插入排序是否有误
        for (int i = low; i <= high; i++) {
            System.out.printf(a[i].toString() + ",");
        }
        System.out.println("实现一次插入排序");*/
    }

    /** 自顶向下归并 */
    public static  void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
//        Comparable[] aux = a.clone();   // aux完全复制，之后aux就无需进行操作了
        sort(a, 0, a.length - 1, aux);
        assert isSorted(a);
    }

    /** 自顶向下归并 重载 */
    public static void sort(Comparable[] a, int low, int high, Comparable[] aux){
        // 将数组a[low..high]排序
        if (high <= low)
            return;

        // high 和 low 之间的差小于3时用插入排序，否则使用归并排序
        if (high-low <= CUTOFF){
            insertSort(a, low, high);
            return;
        }

        int mid = low + (high - low)/2;

        sort(a, low, mid, aux); // 将左半边排序
        sort(a, mid+1, high, aux); // 将右半边排序
        merge(a, low, mid, high, aux); // 归并结果
    }

    /** less 判断*/
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /** exch 交换 */
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
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
        Comparable[] a = {2,6,8,4,1,7,10,9,3,5};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.printf(a[i].toString() + " ");
        }
    }
}
