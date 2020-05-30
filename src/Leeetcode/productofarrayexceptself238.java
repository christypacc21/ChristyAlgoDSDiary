package Leeetcode;

import java.util.Arrays;

public class productofarrayexceptself238 {
    public static int[] _238(int[] nums){
        if (nums == null || nums.length == 0){
            return nums;
        }

        // generate an array that calculated 前 乘sum ---->
        int[] res = new int[nums.length]; //res actually means left_sum here
        res[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            res[i] = res[i-1] * nums[i-1];
        }

        // update the array item one by one to = includes 後 乘sum  <-------
        int right_sum = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            res[i] *= right_sum;
            right_sum *= nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,6};
        System.out.println(Arrays.toString(_238(nums))); //[24, 12, 8, 6] for input {1,2,3,4} // [120, 90, 72, 60] for {3,4,5,6}
    }
}
