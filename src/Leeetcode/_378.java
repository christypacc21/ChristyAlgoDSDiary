package Leeetcode;

public class _378 {
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];
        while(left + 1 < right){
            int mid = (right-left) / 2 + left;
            int num = count(matrix, mid);
            if (num >= k) right = mid;
            else left = mid;
        }
        if (count(matrix, right) <= k - 1) return right;
        return left;
    }
    public static int count(int[][] matrix, int target){
        int n = matrix.length;
        int res = 0;
        int i = n - 1, j = 0;
        while (i >= 0 && j < n){
            if (matrix[i][j] < target){
                res += i + 1;
                j++;
            } else i--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,5,9},{10,11,13},{12,13,15}};
        System.out.println(kthSmallest(nums, 8));
    }
}
