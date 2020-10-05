package Chapter1_1;

public class Ex1_1_20 {
    public static double lnN(int N){
        if(N == 1)
            return 0;
        else
            return Math.log(N) + lnN(N-1);
    }

    public static void main(String[] args) {
        System.out.println(lnN(4) + "");
        System.out.println(Math.log(24));
    }
}
