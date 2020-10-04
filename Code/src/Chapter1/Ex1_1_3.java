package Chapter1;

import algs4.*;

public class Ex1_1_3 {
    public static void main(String[] args) {
        int a = StdIn.readInt();
        int b = StdIn.readInt();
        int c = StdIn.readInt();
        if(a == b && a == c) {
            StdOut.println("equal");
        } else {
            StdOut.println("not equal");
        }
    }
}