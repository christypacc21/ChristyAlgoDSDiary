package Leeetcode;
import java.util.Arrays;
//https://leetcode.com/problems/spiral-matrix-ii/
//59. Spiral Matrix II
//Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
//        Example:
//        Input: 3
//        Output:
//        [
//          [ 1, 2, 3 ],
//          [ 8, 9, 4 ],
//          [ 7, 6, 5 ]
//        ]

public class _59 {
    public static int[][] lc(int n){ // timeO(n) space(O(n)
        int[][] matrix= new int[n][n];
        int rowBegin = 0;
        int rowEnd = n - 1;
        int colBegin = 0;
        int colEnd = n - 1;
        int num = 1; // coz question required start from 1

        while (rowBegin <= rowEnd && colBegin <= colEnd){
            for (int i = colBegin; i <= colEnd; i++){
                matrix[rowBegin][i] = num++;
            }
            rowBegin++;

            for (int i = rowBegin; i <= rowEnd; i++){
                matrix[i][colEnd] = num++;
            }
            colEnd--;

            for(int i = colEnd; i >= colBegin; i--){ // no need if like _54 (coz this question is calling u to generate a squarelike matrix, so every while loop must hv 4 paths
                matrix[rowEnd][i] = num++;
            }
            rowEnd--;

            for(int i = rowEnd; i >= rowBegin; i--){ // no need if like _54
                matrix[i][colBegin] = num++;
            }
            colBegin++;
        }
        return matrix;
    }

    public static void print(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            System.out.println(Arrays.toString((matrix[i])));
        }
    }

    public static void main(String[] args) {
        int num = 3;
//        int num = 10;
        print(lc(num));
    }
}
