package Chapter1;

public class Ex1_1_14 {
    public static int lg(int N) {
        int i = 0;
        while(pow(i) <= N)
            i++;
        return i-1;
    }

    public static int pow(int n) {
        int res = 1;
        for (int i = 0; i < n; i++) {
            res = res * 2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lg(33));
    }
}
