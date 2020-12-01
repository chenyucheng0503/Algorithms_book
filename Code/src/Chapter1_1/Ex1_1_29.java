package Chapter1_1;

public class Ex1_1_29 {
    //返回有序数组a中，小于key的元素个数
    public static int rank(int key, int[] a) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key < a[mid])
                high = mid - 1;
            else if (key > a[mid])
                low = mid + 1;
            else {
                while (a[mid] == a[mid - 1] && mid > 0)
                    mid -= 1;
            }
            return mid;
        }
        return -1;
    }

       public static int count (int key, int[] a)
       {
           int cnt = 0;
           //找到最小的i
           int i = rank(key,a);
           while(a[i]==a[i+1] && i<a.length)
           {
               cnt++;
               i++;
           }
           return cnt;
       }
}
