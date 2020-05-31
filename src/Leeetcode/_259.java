package Leeetcode;
// Leetcode 259: 3Sum Smaller
// Given an array of n integers nums and a target,
// find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
//        Example:
//        Input: nums = [-2,0,1,3], and target = 2
//        Output: 2

//        Explanation: Because there are two triplets which sums are less than 2:
//        [-2,0,1]
//        [-2,0,3]

//        Follow up: Could you solve it in O(n2) runtime?

import java.util.Arrays;

public class _259 {
    public static int lc(int[] nums, int target){ // time O(n^2) space O(1)
        int res = 0;

        Arrays.sort(nums); // step1 sort the array

        for (int i = 0; i < nums.length - 2; i ++){ // step2 降維 (for loop + while two pointers) 處理
            int left = i + 1; //Note that left and right are array's positions, not item value
            int right = nums.length - 1; //Note that left and right are array's positions, not item value
            while (left < right){
                if (nums[i] + nums[left] + nums[right] < target) { // important
                    res += right - left; // important (how to update the res)
                    left++; // important
                } else right--; // important
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,1,3,6,4};
        System.out.println(lc(nums, 2));
    }
}
