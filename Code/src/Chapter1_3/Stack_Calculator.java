package Chapter1_3;

import algs4.*;

/**
 * @author GrahamSa (https://github.com/chenyucheng0503)
 * @ClassName Stack_Calculator.java
 * @Description 利用栈的特性实现一个简单的计算器
 * @References Dijkstra
 * @createTime 2020年12月20日 20:14:00
 */

public class Stack_Calculator {
    public static void main(String[] args) {
        // ops存放运算符, vals存放数值
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        while(!StdIn.isEmpty()){
            String s = StdIn.readString();
            //遇到左括号，则跳过
            if (s.equals("(")) ;
            else if (s.equals("+"))
                ops.push(s);
            else if (s.equals("-"))
                ops.push(s);
            else if (s.equals("*"))
                ops.push(s);
            else if (s.equals("/"))
                ops.push(s);
            else if (s.equals("sqrt"))
                ops.push(s);
            else if (s.equals(")")){
                String op = ops.pop();
                double v = vals.pop();

                if (op.equals("+")) v = vals.pop() + v;
                else if (op.equals("-")) v = vals.pop() - v;
                else if (op.equals("*")) v = vals.pop() * v;
                else if (op.equals("/")) v = vals.pop() / v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                // 将运算结果压回vals
                vals.push(v);
            }
            else        //剩余只有数字情况了
                vals.push(Double.parseDouble(s));
        }
        //最后 vals 里面的数就是计算的数值了
        StdOut.println(vals.pop());
    }
}
