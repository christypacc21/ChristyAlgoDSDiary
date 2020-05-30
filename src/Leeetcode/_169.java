package Leeetcode;

public class _169 {
    public static int majorityElement(int[] nums) {
        int count = 0;
        int res = 0;
        for(int num : nums){
            if(count == 0){
                res = num;
            }
            if(num != res){
                count--;
            } else count++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,3,2,1,2,2,2,2,2,2,2};
//        int[] nums = {2,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
}
