package Leeetcode;
// https://leetcode.com/problems/trapping-rain-water/
// cson gong duc ok
public class _42 {
    public static int lc(int[] height) { // time O(n) space O(1)
        int left = 0;
        int right = height.length - 1;
        int sum = 0;
        int leftMax = 0;
        int rightMax = 0;

        while (left < right){
            if (height[left] < height[right]){
                leftMax = Math.max(height[left], leftMax);
                sum += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(height[right], rightMax);
                sum += rightMax - height[right];
                right--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(lc(nums));
    }
}
