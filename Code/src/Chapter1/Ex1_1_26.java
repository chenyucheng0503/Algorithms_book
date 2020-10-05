package Chapter1;

public class Ex1_1_26 {
    //三个数升序排列
    public static void threeSort(int a, int b, int c){
        int t;
        if (a > b) { t = a; a = b; b = t; }
        if (a > c) { t = a; a = c; c = t; }
        if (b > c) { t = b; b = c; c = t; }
    }
}
