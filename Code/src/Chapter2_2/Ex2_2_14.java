package Chapter2_2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author GrahamSa (https://github.com/chenyucheng0503)
 * @ClassName Ex2_2_14.java
 * @Description 归并有序的队列。编写一个静态方法，将两个有序的队列作为参数，返回一个归并后的有序队列。
 * @References
 * @createTime 2021年03月10日 17:40:00
 */

public class Ex2_2_14 {
    public static Queue<Integer> sort (Queue<Integer> a, Queue<Integer> b){
        Queue<Integer> answer = new LinkedList<Integer>();
        int k = a.size()+b.size();
        for (int i = 0; i < k; i++) {
            if(a.peek() == null){
                answer = combination(answer, b);
            }
            else if(b.peek() == null){
                answer = combination(answer, a);
            }
            else if(less(a.peek(), b.peek())){
                answer.add(a.poll());
            }
            else{
                answer.add(b.poll());
            }
        }

        return answer;
    }

    /** 合并队列 */
    public static Queue<Integer> combination(Queue<Integer> a, Queue<Integer> b){
      for(Integer s:b){
          a.add(s);
      }
      return a;
    }

    /** show 打印队列 */
    public static void show(Queue<Integer> a){
      for (Integer i : a){
          System.out.printf(i + " ");
      }
    }

    /** less 判断*/
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        // 创建队列a
        Queue<Integer> a = new LinkedList<Integer>();
        a.offer(1);
        a.offer(3);
        a.offer(5);
        a.offer(7);
        a.offer(9);

        //创建队列b
        Queue<Integer> b = new LinkedList<Integer>();
        b.offer(2);
        b.offer(4);
        b.offer(6);
        b.offer(8);
        b.offer(10);

        //Queue<Integer> answer = sort(a, b);
        show(sort(a, b));
    }
}
