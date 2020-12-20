package Chapter1_3;

/**
 * @author GrahamSa (https://github.com/chenyucheng0503)
 * @ClassName FixedCapacityStackOfStrings.java
 * @Description 实现最简单的 固定长字符串栈
 * @References
 * @createTime 2020年12月20日 20:36:00
 */

public class FixedCapacityStackOfStrings {
    private String[] a;     //固定数组
    private int N;          //长度，相当于游标

    // 构造函数
    public FixedCapacityStackOfStrings(int n) {
        a = new String[n];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(String s) {
        a[N++] = s;     //压入一个s，同时 N 往后移动一位
    }

    public String pop() {
        return a[--N];
    }
}
