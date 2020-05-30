package Leeetcode;

//Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
//        Example:
//
//        Input: [0,1,0,3,12]
//        Output: [1,3,12,0,0]
//        Note:
//
//        You must do this in-place without making a copy of the array.
//        Minimize the total number of operations.

import java.util.Arrays;

//time O(n)
//space O(1)

public class _283 {
    //num of operations = nums.length
    public static int[] moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) return nums;

        int start = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[start] = nums[i];
                start++;
            }
        }

        while(start <= nums.length - 1){
            nums[start] = 0;
            start++;
        }

        return nums;
    }

    // nums of operations = 2 * num of non-zero items
    public static int[] moveZeroes_2(int[] nums){
        if(nums == null || nums.length == 0) return nums;

        for(int i = 0, j = 0; i < nums.length; i++){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        return nums;
    }
//    public static int[] moveZeroes(int[] nums) {
//        if(nums == null || nums.length == 0) return nums;
//
//        int index = nums.length - 1;
//        int left = nums.length - 1;
//        while(index >= 0){
//            if(nums[index] == 0){
//                swap(nums, index, left);
//                left--;
//            }
//            index--;
//        }
//        return nums;
//    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        System.out.println(Arrays.toString(moveZeroes(nums)));
        int[] nums2 = {0,1,0,3,12};
        System.out.println(Arrays.toString(moveZeroes_2(nums2)));
    }
}




// 0 0 1 3 12
//     l
//         i
//
//    public static int[] moveZeroes(int[] nums) {
//        if(nums == null || nums.length == 0) return nums;
//
//        int index = 0;
//        int left = 0;
//        while(index <= nums.length-1){
//            if(nums[index] == 0){
//                swap(nums, index, left);
//                left++;
//            }
//            index++;
//        }
//        return nums;
//    }





 //[3, 1, 12, 0, 0]
//    public static int[] moveZeroes(int[] nums) {
//        if(nums == null || nums.length == 0) return nums;
//
//        int index = nums.length - 1;
//        int left = nums.length - 1;
//        while(index >= 0){
//            if(nums[index] == 0){
//                swap(nums, index, left);
//                left--;
//            }
//            index--;
//        }
//        return nums;
//    }