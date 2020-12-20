package Chapter1_3;

import algs4.*;
/**
 * @author GrahamSa (https://github.com/chenyucheng0503)
 * @ClassName FixedCapacityStackOfStrings_Example.java
 * @Description
 * @References
 * @createTime 2020年12月20日 20:46:00
 */

public class FixedCapacityStackOfStrings_Example {
    public static void main(String[] args) {
        FixedCapacityStackOfStrings s;
        s = new FixedCapacityStackOfStrings(100);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}
