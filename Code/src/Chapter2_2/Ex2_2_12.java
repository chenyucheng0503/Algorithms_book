package Chapter2_2;

import static java.lang.System.arraycopy;

/**
 * @author GrahamSa (https://github.com/chenyucheng0503)
 * @ClassName Ex2_2_12.java
 * @Description 次线性的额外空间。用大小 M 将数组分为 N/M 块（简单起见，设 M 是 N 的约数）。实现一个 归并方法，使之所需的额外空间减少到 max( M , N / M )：(i) 可以先将一个块看做一个元素，将块的第一个元素作为块的主键，用选择排序将块排序；(ii) 遍历数组，将第一块和第二块归并，完成后将第二块和第三块归并，等等。
 * 这道题网上的参考资料不多，不保证正确
 * Thanks to https://softwareengineering.stackexchange.com/questions/179431/sublinear-extra-space-mergesort
 * @createTime 2020年12月14日 10:31:00
 */

public class Ex2_2_12 {
    /** 构造函数 */
    public Ex2_2_12() {}

    private static void merge(Comparable[] a, int low, int mid, int high, Comparable[] aux){
        // 断言初始数组有序
        assert isSorted(a, low, mid);
        assert isSorted(a, mid+1, high);

        // 将a复制一份到aux
        arraycopy(a, low, aux, 0, high-low+1);

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

    /** 专用Merge函数，只需要 N/M 空间的辅助函数aux */
    private static void advancedMerge(Comparable[] a, int low, int mid, int high, Comparable[] aux){
        // 断言初始数组有序
        assert isSorted(a, low, mid);
        assert isSorted(a, mid+1, high);

        // 复制a[mid+1,high] 到 aux
        arraycopy(a, mid+1, aux, 0,high-mid);

        // 初始化游标，m为a[low,mid]的最后一位，n为aux[mid+1,high]的最后一位
        int m = mid-low, n = high-mid-1;
        // 倒着从后往前走，直接在原数组上进行覆盖
        while (high > low) {
            if (less(a[m], aux[n]))
                a[high--] = aux[n--];
            else
                a[high--] = a[low + (m--)];

            // 当 aux 游标走到尽头时，可以直接break，因为这意味着a上的剩余部分均小于aux[0]并有序
            if (n < 0)
                break;
            // 当 a 的游标走到尽头时，说明a[0]比aux剩余部分要大，所以a的剩余部分要替换成aux
            else if (m < low){
                arraycopy(aux, 0, a, low, n);
                break;
            }
        }

        assert isSorted(a, low, high);
    }

    /** 自顶向下归并函数，处理 aux 辅助函数 */
    private static void sort(Comparable[] a, int M){
        int N = a.length;
        Comparable[] aux = new Comparable[Math.max(M, N/M)];

        // 对块进行选择排序
        selectSortBlock(a, M);

        // 对每一个块内部进行归并
        for (int i = 0; i < M; i++) {
            sort(a, 0 + i*(N/M), N/M-1 + i*(N/M), aux);
        }

        // 对块整合归并
    }

    /** 重载的自顶向下归并 */
    private static void sort(Comparable[]a, int low, int high, Comparable[] aux){
        // 将数组a[low..high]排序
        if (high <= low)
            return;

        int mid = low + (high - low)/2;

        sort(a, low, mid, aux); // 将左半边排序
        sort(a, mid+1, high, aux); // 将右半边排序
        advancedMerge(a, low, mid, high, aux); // 归并结果
    }

    /** 选择排序所有块 */
    private static void selectSortBlock(Comparable[] a, int M){
        // 将a[]按升序排列
        int N = a.length;
        for (int i = 0; i < N; i += N/M)
        {
            // 将a[i]的块 和 a[i+1..M]的块中 最小的块交换
            int min = i;                    // 最小元素的索引
            for (int j = i+N/M; j < N; j += N/M)
                if (less(a[j], a[min])) min = j;


            // 交换块元素
            for (int j = 0; j < N/M; j++) {
                exch(a, i+j, min+j);
            }
        }
    }


    /** less 判断*/
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /** exch 交换*/
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

    /** main */
    public static void main(String[] args) {
        Comparable[] a = {8,4,6,7,1,3,2,9,5};
//        selectSortBlock(a, 3);
//        Comparable[] aux = new Comparable[4];
//        advancedMerge(a, 0, 3, 7, aux);
        sort(a, 3);
        for (int i = 0; i < a.length; i++){
            System.out.printf(a[i] + " ");
        }
    }
}
