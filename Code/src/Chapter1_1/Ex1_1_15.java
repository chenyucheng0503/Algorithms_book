package Chapter1_1;

public class Ex1_1_15 {
    public static int[] histogram(int[] a, int M){
        int[] res = new int[M];
        for (int i = 0; i < a.length; i++) {
            if(a[i] >= 0 && a[i] < M)
                res[a[i]] += 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] trans_arr = histogram(arr, 7);
        for (int i = 0; i < trans_arr.length; i++) {
            System.out.print(trans_arr[i] + ",");
        }
    }
}
