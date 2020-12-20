package Chapter1_3;
import algs4.*;

/**
 * @author GrahamSa (https://github.com/chenyucheng0503)
 * @ClassName Queue_Example.java
 * @Description 用队列来实现如何将 String 转换成 int[]
 * @References
 * @createTime 2020年12月20日 19:54:00
 */

public class Queue_Example {
    public static int[] readInts(String name) {
        In in = new In(name);
        //创建队列
        Queue<Integer> q = new Queue<Integer>();

        //读取每一个数，加入队列
        while(!q.isEmpty())
            q.enqueue(in.readInt());

        int N = q.size();
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = q.dequeue();
        }

        return result;
    }
}
