package Leeetcode;
// https://leetcode.com/problems/remove-element/
public class _27 {

    public static int removeElement(int[] nums, int val) {
        // time O(n)
        // space O(1)
        if(nums == null || nums.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != val){
                nums[res++] = nums[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(nums, 2));
    }






    // my own ans on leetcode
//    public int removeElement(int[] nums, int val) {
//        if(nums == null || nums.length == 0) return 0;
//        int right = nums.length - 1;
//        for(int i = nums.length - 1; i >= 0; i--){
//            if(nums[i] == val){
//                int temp = nums[i];
//                nums[i] = nums[right];
//                nums[right] = nums[i];
//                right--;
//            }
//        }
//        return right + 1;
//    }
}
