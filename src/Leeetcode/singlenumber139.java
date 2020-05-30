package Leeetcode;

public class singlenumber139 {
    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,8,8,2,3,3,1,0,9,9};
        singleNumber(nums);
    }
}
