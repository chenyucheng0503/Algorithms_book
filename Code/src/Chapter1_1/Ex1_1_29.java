package Chapter1_1;

import java.util.Arrays;

public class Ex1_1_29 {
    //返回有序数组a中，小于key的元素个数
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
            else if(mid > 0 && a[mid-1] == key) //在重复元素中，保证选择index最小的元素
                high = mid - 1;
            else
                return mid;
        }
        return -1;
    }

   public static int count (int key, int[] a)
   {
       int cnt = 1;
       //找到最小的i
       int index = rank(key,a);

       //没有找到key
       if(index == a.length || a[index] != key)
           return -1;

       while(a[index] == a[index+1] && index < a.length-1)
       {
           cnt++;
           index++;
       }
       return cnt;
   }

    public static void main(String[] args) {
        int[] whitelist = {1,3,5,5,5,6,6,6,6,7,8};
        Arrays.sort(whitelist);
        int key = 6;
        int index = rank(key, whitelist);
        System.out.println("共有" + index + "个元素比" + key + "小");
        int count = count(key, whitelist);
        System.out.println("共有" + count + "个元素跟" + key + "一样大");
    }
}
