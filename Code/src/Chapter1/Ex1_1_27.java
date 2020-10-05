package Chapter1;

public class Ex1_1_27 {
    static int depth = 0;

    //递归方法，尤其耗费资源，理论递归次数为2^102-1
    public static double binomial(int N, int k, double p)
    {
        depth += 1;
        System.out.println(depth);
        if (N == 0 && k == 0) return 1.0;
        if (N < 0 || k < 0) return 0.0;
        return (1.0 - p)*binomial(N-1, k, p) + p*binomial(N-1, k-1, p);
    }

    public static double binomial_modified(int N, int k, double p) {
        //使用递推公式:P = C(N,k) p^k * (1-p)^(N-k)
        double[][] f = new double[N + 1][k + 1];
        f[0][0] = 1.0;

        //f(N,0,p)
        for (int i = 1; i < N + 1; i++) {
            f[i][0] = (1.0 - p) * f[i - 1][0] + 0.0;
        }

        // f(N,k,p)
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                f[i][j] = (1.0 - p) * f[i - 1][j] + p * f[i - 1][j - 1];
            }
        }

        return f[N][k];
    }

    public static void main(String[] args) {
//        System.out.println(binomial(100, 50, 0.25));
//        System.out.println(depth);
        System.out.println(binomial_modified(100, 50, 0.25));
    }
}
