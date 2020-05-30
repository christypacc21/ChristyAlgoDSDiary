package Leeetcode;

import java.util.Arrays;

public class _80 {
    //time O(n)
    //space O(1)
    public static int _80 (int[] nums){
        if (nums == null || nums.length == 0) return 0;
        if (nums.length <= 2) return nums.length;// not a must to always be the same template so be careful.

        int count = 2; //count is 待插入的位置     //*
        for (int i = 2; i < nums.length; i++){   //*
            if (nums[i] != nums[count-2]){       //*** important if (nums[i] != nums[count-2]) check position -2 is enough (ng ming jao suen)
                nums[count++] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,1,1,1,2,3,3};
        System.out.println(_80(nums));
    }
}




//    public static int _80 (int[] nums){
//        if(nums == null || nums.length == 0) return 0;
//        int count = 1;
//        int temp = 0;
//        for(int i = 1; i < nums.length; i++){
//            if(nums[count-1] <= nums[i] && temp <= 2){
//                nums[count] = nums[i];
//                count++;
//                temp++;
//            }else{
//                temp = 0;
//            }
//        }
//        System.out.println(Arrays.toString(nums));
//        return count;
//    }



