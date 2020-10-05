package Chapter1_1;

import algs4.*;

public class Ex1_1_11 {
    //本人写的
    public static void print2DBooleanArray(boolean[][] boolArray){
        //获取行列值
        int row = boolArray.length;
        int col = boolArray[0].length;
        int row_num = String.valueOf(row).length();
        int col_num = String.valueOf(col).length();

                //打印列号
        String firstLine = String.format("%"+ row_num+ "s", " ");
        for (int i = 0; i < col; i++) {
            firstLine += " " + String.format("%" + col_num + "d", i) + " ";
        }
        System.out.println(firstLine);

        //打印主体
        for (int j = 0; j < row; j++) {
            String thisLine = String.format("%" + row_num + "d", j);
            for (int i = 0; i < col; i++) {
                if (boolArray[j][i] == true)
                    thisLine += " " + String.format("%" + col_num + "s", "*") + " ";
                else
                    thisLine += " " + String.format("%" + col_num + "s", "-") + " ";
            }
            System.out.println(thisLine);
        }
    }

    //别人答案
    public static void printBoolArr (boolean[][] arr) {
        StdOut.print(' ');
        for (int i = 0; i < arr[0].length; i++) {
            StdOut.print(i);
        }
        StdOut.println();
        for (int i = 0; i < arr.length; i++) {
            StdOut.print(i);
            for (int j = 0; j < arr[i].length; j++) {
                StdOut.print(arr[i][j] ? '*' : ' ');
            }
            StdOut.println();
        }
    }

    public static void main(String[] args) {
        boolean[][] boolArray = new boolean[11][11];
        boolArray[1][2] = true;
        boolArray[2][2] = true;
        print2DBooleanArray(boolArray);
        System.out.println("-------------------------");
        printBoolArr(boolArray);
    }
}
