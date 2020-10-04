package Chapter1;

import algs4.*;

//斐波那契
public class Ex1_1_6 {
    public static void main(String[] args) {
        int f = 0;
        int g = 1;
        for (int i = 0; i < 16; i++) {
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }
    }
}
