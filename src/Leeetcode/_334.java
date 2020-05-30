package Leeetcode;
//https://leetcode.com/problems/increasing-triplet-subsequence/


//time O(n)
//space O(1)
public class _334 {
    public static boolean _334(int[] nums){
        int min = Integer.MAX_VALUE, secMin = Integer.MAX_VALUE;
        for(int num : nums){
            if(num <= min) min = num; //note here is <= instead of <, to avoid going to next line's logic
            else if(num < secMin) secMin = num;
            else if(num > secMin) return true;
        }
        return false;
//        for(int i =0; i<nums.length;i++){
//            if(nums[i] < min) min = nums[i];
//            else if(num)
//        }
    }
}
