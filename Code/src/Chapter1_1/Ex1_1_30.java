package Chapter1_1;

public class Ex1_1_30 {
    public static int ifPrime(int m, int n){
        if (n == 0)
            return m;
        int r = m % n;
        return ifPrime(n, r);
    }

    public static void main(String[] args) {
        boolean[][] boolArray = new boolean[11][11];
        for (int i = 0; i < boolArray.length; i++) {
            for (int j = 0; j < boolArray[0].length; j++){
                if(ifPrime(i, j) == 1)
                    boolArray[i][j] = true;
                else
                    boolArray[i][j] = false;
                System.out.print(String.format("%6s,", boolArray[i][j]+""));
            }
            System.out.println();
        }
    }
}
