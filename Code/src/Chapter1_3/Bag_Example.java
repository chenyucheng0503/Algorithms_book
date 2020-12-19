package Chapter1_3;
import algs4.*;
import java.util.Iterator;

/**
 * @author GrahamSa (https://github.com/chenyucheng0503)
 * @ClassName Bag_Example.java
 * @Description
 * @References
 * @createTime 2020年12月19日 14:51:00
 */

public class Bag_Example {
    public static void main(String[] args) {
        Bag<Double> numbers = new Bag<Double>();
        while (!StdIn.isEmpty()) numbers.add(StdIn.readDouble());
        int N = numbers.size();
        double sum = 0.0;
        for (double x : numbers)
            sum += x;

        double mean = sum / N;

        sum = 0.0;
        for (double x : numbers)
            sum += (x - mean) * (x - mean);
        double std = Math.sqrt(sum / (N - 1));
        StdOut.printf("Mean: %.2f\n", mean);
        StdOut.printf("Std dev: %.2f\n", std);
    }
}
