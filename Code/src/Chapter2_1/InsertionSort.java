package Chapter2_1;
import algs4.*;

public class InsertionSort extends ExampleSort{
    public static void sort(Comparable[] a) {
        //将a[]升序排列
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
            Comparable t = a[i];
            a[i] = a[j];
            a[j] = t;
        }

    public static boolean isSorted(Comparable[] a) {
        // 测试数组元素是否有序
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    private static void show(Comparable[] a) {
        // 在单行中打印数
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static void main(String[] args) {
        // 从标准输入读取字符串，将它们排序并输出
//            String[] a = StdIn.readAllStrings();
        String[] a = {"as","d","asd","as","d"};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
