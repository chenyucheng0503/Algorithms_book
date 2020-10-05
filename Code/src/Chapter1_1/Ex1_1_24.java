package Chapter1_1;

public class Ex1_1_24 {
    public static int Euclid(int p, int q, int depth){
        //打印p q
        if (depth == 1)
            System.out.println(String.format("p:%d q:%d", p, q));
        else
            System.out.println(String.format("%" + 3*(depth-1) +"sp:%d q:%d", " ", p, q));

        if (q == 0)
            return p;
        int r = p % q;
        return Euclid(q, r, depth+1);
    }

    public static void main(String[] args) {
        System.out.println("The final answer is " + Euclid(105, 24, 1));
        System.out.println("------------------------------");
        System.out.println("The final answer is " + Euclid(1111111, 1234567, 1));
    }
}
