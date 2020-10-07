package Chapter1_1;

public class Ex1_1_29 {
    //返回有序数组a中，小于key的元素个数
    public static int rank(int key, int[] a)
    {
        int low = 0;
        int high = a.length - 1;
        int max_number = 0;

        while (low <= high)
        {
            int mid = low + (high-low) / 2;
            if (key < a[mid])
            {
                high = mid - 1;
                max_number = mid - 1;
            }
            else if(key > a[mid])
                low = mid + 1;
            else
                return mid;
        }
        return -1;
    }
}
