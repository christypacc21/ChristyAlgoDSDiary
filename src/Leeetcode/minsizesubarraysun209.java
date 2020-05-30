package Leeetcode;

public class minsizesubarraysun209 {
    public static int lc209(int s, int[] nums){
        int res = Integer.MAX_VALUE; //important （coz we use Math.min below. if res id initialised with =0, then Math.min(0, i - left + 1) will always be 0 which is not accurate.
        int left = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            while (left <= i && sum >= s) { //important
                res = Math.min(res, i - left + 1); //important i - left + 1 -> current index - beginning index + 1(+1 is coz res should also include the leftmost num of this sliding window)
                sum -= nums[left++]; //important
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res; //important
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(lc209(7, nums));
    }
}
