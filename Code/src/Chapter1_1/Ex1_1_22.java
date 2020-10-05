package Chapter1_1;

import java.util.Arrays;

public class Ex1_1_22 {
    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1, 1);
    }

    public static int rank(int key, int[] a, int low, int high, int depth) {
        //打印low, high
        if (depth == 1)
            System.out.println(String.format("%d %d", low, high));
        else
            System.out.println(String.format("%" + 3*(depth-1) +"s%d %d", " ", low, high));

        //如果key存在于a[]中，它的索引不会小于lo且不会大于hi
        if (low > high)
            return -1;
        int mid = low + (high - low) / 2;
        if (key < a[mid])
            return rank(key, a, low, mid - 1, depth+1);
        else if (key > a[mid])
            return rank(key, a, mid + 1, high, depth+1);
        else
            return mid;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,7,8,9,11,14,16,18};
        Arrays.sort(arr);
        rank(7, arr);
    }
}
