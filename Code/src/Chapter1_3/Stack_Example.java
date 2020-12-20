package Chapter1_3;
import algs4.*;

/**
 * @author GrahamSa (https://github.com/chenyucheng0503)
 * @ClassName Stack_Example.java
 * @Description 利用栈实现逆序输出，无需知道大小
 * @References
 * @createTime 2020年12月20日 20:07:00
 */

public class Stack_Example {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        //直接读取，压入栈
        while (!StdIn.isEmpty())
            stack.push(StdIn.readInt());
        //逆序出栈，刚好反序
        for(int i : stack)
            System.out.println(i);
    }
}
