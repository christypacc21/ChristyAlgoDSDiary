package Leeetcode;

//https://leetcode.com/problems/search-a-2d-matrix/
// ~ LC240

public class _74 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0;
        int end = row * col - 1;

        while (start <= end) {
            int mid = (end - start) / 2 + start;
            int value = matrix[mid / col][mid % col]; //背下来 //important
            if (value == target) {
                return true;
            } else if (value < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = { {1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 50} };
        System.out.println(searchMatrix(nums, 13));
    }
}
