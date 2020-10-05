package Chapter1;

public class Ex1_1_21 {
    public static void printNameInt(String name, int grade1, int grade2){
        System.out.printf("%5s %5d %5d %.3f\n", name, grade1, grade2, (double)grade1/grade2);
    }

    public static void main(String[] args) {
        printNameInt("陈俞丞", 90, 100);
        printNameInt("叶贞怡", 60, 80);
    }
}
