package Chapter1;

import java.util.Arrays;
import algs4.*;

//二分查找
public class BinarySearch
{
    public static int rank(int key, int[] a)
    {
        int low = 0;
        int high = a.length - 1;
        while (low <= high)
        {
            int mid = low + (high-low) / 2;
            if (key < a[mid])
                high = mid - 1;
            else if(key > a[mid])
                low = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] whiteList = In.readInts(args[0]);
        //对白名单排序
        Arrays.sort(whiteList);

        while (!StdIn.isEmpty())
        {
            int key = StdIn.readInt();
            if(rank(key, whiteList) == -1)
            {
                StdOut.println(key);
            }
        }
    }
}
