package Chapter1;

public class Ex1_1_9 {
    public static String toBinaryString(int N){
        String s = "";
        for (int i = N; i > 0; i /= 2) {
            s = (i % 2) + s;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(toBinaryString(3));
    }
}
