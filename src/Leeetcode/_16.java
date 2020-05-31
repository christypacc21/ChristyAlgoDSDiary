package Leeetcode;

import java.util.Arrays;
// https://leetcode.com/problems/3sum-closest/
// Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. (if item value 重覆 is also ok)
// Return the sum of the three integers. You may assume that each input would have exactly one solution.
//        Example 1:
//        Input: nums = [-1,2,1,-4], target = 1
//        Output: 2
//        Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
//
//        Constraints:
//        3 <= nums.length <= 10^3
//        -10^3 <= nums[i] <= 10^3
//        -10^4 <= target <= 10^4

public class _16 {
    public static int lc(int[] nums, int target){ //time O(n^2) space O(1)
        int res = nums[0] + nums[1] + nums[nums.length - 1]; // make a random default res (cos must hv one and only one combination to return)
        Arrays.sort(nums); // sort

        // use forloop + two pointers while(start end or say left right) -> in order to loop thru every possible combination to compare
        for(int i = 0; i < nums.length - 2; i++){ //3sum
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end){ //start, end represents
                int sum = nums[i] + nums[start] + nums[end]; //important
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(res - target)){ // important - compare to find the smaller combination
                    res = sum;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        System.out.println(lc(nums, 1));
    }
}
