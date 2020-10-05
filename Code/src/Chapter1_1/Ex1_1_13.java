package Chapter1_1;

public class Ex1_1_13 {
    public static void printTransArray(int[][] arr)
    {
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(String.format(" %3d ", arr[j][i]));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{0,1,2,3}, {4,5,6,7}, {8,9,10,11}};
        printTransArray(arr);
    }
}
