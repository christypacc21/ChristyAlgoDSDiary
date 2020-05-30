package Leeetcode;

//0, 1, and 2 -》 red, white, and blue

//Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
//Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
//Note: You are not suppose to use the library's sort function for this problem.

//Input: [2,0,2,1,1,0]
//Output: [0,0,1,1,2,2]
//         l         r

// 0,0,1,2,0,2,2,1,0,1
// 0,0,0,0,1,1,1,2,2,2
//         l
//             r
//               i

import java.lang.reflect.Array;
import java.util.Arrays;
public class _75 {
    public static int[] _75(int[] nums){
        if(nums == null || nums.length == 0) return nums;
        int left = 0; // locate 0's last position
        int right  = nums.length - 1; // locate 1's last position
        int index = 0; // to do iteration in while loop
        while(index <= right){
            if(nums[index] == 0){
                swap(nums, index, left); // or swap(nums, index++, left++);
                index++;
                left++;
            } else if (nums[index] == 1){
                index++;
            } else { // ==2
                swap(nums, index, right); // or swap(nums, index, right--);
                right--;
            }
        }
        return nums;
    }

    public static void swap(int[]nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,2,0,2,2,1,0,1};
        System.out.println(Arrays.toString(_75(nums)));
    }

}
