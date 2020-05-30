package Leeetcode;

import java.util.ArrayList;
import java.util.List;

public class _54 {
    public static List<Integer> _54(int[][] matrix) { // time O(n * m) space O(n * m) -> n * m : 總元素個數 (actually (n*m) here implies the "n" we normally talk about)(but since the input format is a matrix, we use n * m to represent the number of items, so here is like i(num of big arrays) * j(num of small arrays)
        List<Integer> res = new ArrayList<>();

        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return res;
        }

        int rowBegin = 0; // -
        int rowEnd = matrix.length -1; //-1 coz int is  array index (array starts from 0)
        int colBegin = 0; // |
        int colEnd = matrix[0].length - 1; //-1 coz int is array index (array starts from 0)

        while(rowBegin <= rowEnd && colBegin <= colEnd){
            for(int i = colBegin; i <= colEnd; i++){ // ->
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++;

            for(int i = rowBegin; i <= rowEnd; i++){ // |V
                res.add(matrix[i][colEnd]);
            }
            colEnd--;

            if(rowBegin <= rowEnd){ //must (eg for case matrix_1_
                for(int i = colEnd; i >= colBegin; i--){ // <-
                    res.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            if(colBegin <= colEnd){ //must (eg for case matrix_4)
                for(int i = rowEnd; i >= rowBegin; i--){ // ^|
                    res.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        int[][] matrix_1 = {
                {1,2,3},
        };

        int[][] matrix_2 = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };

        int[][] matrix_3 = {
                {1,2,3,4},
                {5,6,7,8},
        };

        int[][] matrix_4 = {
                {1},
                {2},
                {3}
        };

//        System.out.println(_54(matrix));
        System.out.println(_54(matrix_1));
//        System.out.println(_54(matrix_2));
//        System.out.println(_54(matrix_3));
//        System.out.println(_54(matrix_4));
    }
}
