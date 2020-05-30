package Leeetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class _26 {
    public static int[] _26(int[] nums) {
        // time O(n)
        // space O(1)
        if(nums == null || nums.length == 0) return nums;
        int count = 1; //count is 待插入的位置
        for(int i = 1; i < nums.length; i++){
            if(nums[count - 1] < nums[i]){ // or if(nums[i - 1] < nums[i]){
                nums[count++] = nums[i];
            }
        }
        System.out.println(count);
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(Arrays.toString(_26(nums)));
    }
}



    // my failed code
//    public static int[] _26(int[] nums) {
//        // time O(n)
//        // space O(1)
//        if(nums == null || nums.length == 0) return nums;
//        int res = 0;
//        for(int i = 0; i < nums.length; i++){
//            // if(nums[i] == nums[res]) nums[res++] = nums[i];
//            if(nums[i] != nums[res]){
//                nums[res] = nums[i];
//                res++;
//            }
//        }
//        System.out.println(res);
//        return nums;
//    }
