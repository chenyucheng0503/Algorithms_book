package Chapter1;

import algs4.*;

public class Ex1_1_19 {
        static final int M = 100;
        static long[] arr = new long[M];

        public static long F(int N) {
            if (N == 0)
                arr[N] = 0;
            else if (N == 1)
                arr[N] = 1;
            else
                arr[N] = arr[N-1] + arr[N-2];
            return arr[N];
        }

        public static void main(String[] args) {
            for (int N = 0; N < 100; N++)
                StdOut.println(N + " " + F(N));
        }

}
