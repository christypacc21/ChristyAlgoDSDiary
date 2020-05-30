package Leeetcode;
//https://leetcode.com/problems/rotate-image/

import java.util.Arrays;

public class _48 {
    public static void lc48(int[][] matrix){
        int len_i = matrix.length;
        //主
        for(int i = 0; i < len_i; i++){
            for(int j = 0; j < i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //垂
        for(int i = 0; i < len_i; i++){
            int len_j = matrix[i].length;
            for(int j = 0; j < len_j / 2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len_j - 1 - j];
                matrix[i][len_j - 1 - j] = temp;
            }
        }
        print(matrix);
    }


    // i -> vertical , j -> horizontal

    /**
     * [
     *   [(0,0),(0,1),(0,2)],   i=0   j=0,1,2  [[1,2,3],
     *   [(1,0),(1,1),(1,2)],   i=1   j=0,1,2   [4,5,6],
     *   [(2,0),(2,1),(2,2)]    i=2   j=0,1,2   [7,8,9]]
     * ],
     */

    /**
     * [ [x]       i=0
     *   [v,x]     i=1 j=0
     *   [v,v,x] ] i=2 j=0,1
     *  "v" above means do the 換位
     */
    public static void _1_diagonal(int[][] matrix){ // \
        for (int i = 0; i < matrix.length; i++) { //vertical screen
            for (int j = 0; j < i; j++) { //horizontal screen
                // 換位 - [i][j]<->[j][i] eg (0,2)<->(2,0)
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        print(matrix);
    }

    /**
     * [ [v,v,x]        i=0, j=0,1
     *   [v,x]          i=1 j=0
     *   [x]]           i=2
     *  "v" above means do the 換位
     */
    public static void _2_counterDiagonal(int[][] matrix){ // /
        int len = matrix.length; //vertical's length
        for (int i = 0; i < len; i++) { //vertical screen
            for (int j = 0; j < len - 1 - i; j++){ //horizontal screen
                // 換位 - to find the location of the item to be interchanged j->len-1-i | i->len-1-j (不明就先背吧)
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len-1-j][len-1-i];
                matrix[len-1-j][len-1-i] = temp;
            }
        }
        print(matrix);
    }

    /**
     * [ [v,x]        i=0, j=0,1
     *   [v,x]          i=1 j=0
     *   [v,x] ]          i=2
     *  "v" above means do the 換位
     */
    public static void _3_horizontal(int[][] matrix){ // -
        int len = matrix.length;
        for (int i = 0; i < len / 2; i++){
            for(int j = 0; j < matrix[i].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - i][j];
                matrix[len - 1 - i][j] = temp;
            }
        }
        print(matrix);
    }

    public static void _4_vertical(int[][] matrix){ // |
        int len = matrix.length;
        for (int i = 0; i < len; i++){
            int j_len = matrix[i].length;
            for(int j = 0; j < j_len / 2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][j_len - 1 - j]; // 比較好理解的說法： [j] 是左邊離左盡的距離, [j_len - 1 - j]是右邊離右盡的距離 -> coz 要symmetric(對稱).
                matrix[i][j_len - 1 - j] = temp;
            }
        }
        print(matrix);
    }



    public static void print(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            System.out.println(Arrays.toString((matrix[i])));
        }
    }

    public static void main(String[] args) {
        int[][] matrix_0 = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        lc48(matrix_0);
        System.out.println("-----");

        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        _1_diagonal(matrix);
        System.out.println("-----");
        int[][] matrix2 = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        _2_counterDiagonal(matrix2);
        System.out.println("-----");
        int[][] matrix3 = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9},
                {10,11,12},
                {13,14,15},
                {16,17,18}
        };
        _3_horizontal(matrix3);
        System.out.println("-----");
        int[][] matrix4 = new int[][]{
                {1,2,3,0},
                {4,5,6,0},
                {7,8,9,0},
                {10,11,12,0},
                {13,14,15,0}
        };
        _4_vertical(matrix4);
        System.out.println("-----");
    }
}
