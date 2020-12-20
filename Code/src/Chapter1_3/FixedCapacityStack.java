package Chapter1_3;
import algs4.*;

/**
 * @author GrahamSa (https://github.com/chenyucheng0503)
 * @ClassName FixedCapacityStack.java
 * @Description 实现泛型的固定栈
 * @References
 * @createTime 2020年12月20日 21:38:00
 */

public class FixedCapacityStack<Item> {
    private Item[] a;     //固定数组
    private int N;          //长度，相当于游标

    // 构造函数,此处需要强制转换类型
    public FixedCapacityStack(int n) {
        a = (Item[]) new Object[n];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        a[N++] = item;
    }

    public Item pop() {
        return a[--N];
    }

}
