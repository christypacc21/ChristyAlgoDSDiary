package Leeetcode;
// https://leetcode.com/problems/search-a-2d-matrix-ii/description/
public class _240 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int row = 0;
        int col = matrix[0].length - 1;

        while (col >= 0 && row <= matrix.length - 1){
            if (target == matrix[row][col]){
                return true;
            } else if (target < matrix[row][col]){
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,   4,  7, 11, 15},
        {2,   5,  8, 12, 19},
        {3,   6,  9, 16, 22},
        {10, 13, 14, 17, 24},
        {18, 21, 23, 26, 30} };
        System.out.println(searchMatrix(nums, 13));
        System.out.println(searchMatrix(nums, 20));
    }
}
