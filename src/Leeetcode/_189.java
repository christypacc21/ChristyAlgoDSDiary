package Leeetcode;

import java.util.Arrays;

//Input: nums = [1,2,3,4,5,6,7], k = 3
//Output: [5,6,7,1,2,3,4]

public class _189 {
    public static void _189_1(int[] nums, int k){ //time O(n) space O(n)
        if(nums == null || nums.length == 0) return;

        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            temp[(i + k) % nums.length] = nums[i]; //important -> u hv to know mod. (k=3) (i=0)3%7=3,4%7=4,5%7=5,6%7=6,7%7=0,(i=5)8%7=1, 9%7=2,
        }
        for (int i = 0; i < nums.length; i++){
            nums[i] = temp[i];
        }
        System.out.println(Arrays.toString(nums));
    }


    public static void _189_2(int[] nums, int k){ // reverse method, time O(n), space O(1)
        if(nums == null || nums.length == 0) return;
        k %= nums.length; // important ->
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
    public static void reverse(int[] nums, int start, int end){ // important
        while (start < end){ // note that  is <
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums1= {1,2,3,4,5,6,7};
        _189_1(nums1,3);
        int[] nums2= {-1,-100,3,99};
        _189_1(nums2,2);
        int[] nums3= {-1,-100,3,99};
        _189_2(nums3,2);
        int[] nums4= {1,2,3,4,5,6,7};
        _189_2(nums4,3);
    }
}
