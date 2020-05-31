package Leeetcode;

import java.util.Arrays;
import java.util.HashMap;
//https://www.callicoder.com/two-sum-problem/

public class _1 {
    //time O(n) spaceO(n)
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2){
            return new int[] {-1,-1};
        }

        // 寫法 1 cson
//        int[] res = new int[]{-1,-1};
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < nums.length; i++){
//            if (map.containsKey(target - nums[i])) {
//                res[0] = map.get(target - nums[i]);
//                res[1] = i;
//                break;
//            }
//            map.put(nums[i], i);
//        }
//        return res;

        // 寫法 2
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[] {};
    }



    public static void main(String[] args) {
        int[] nums = {16, 2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
        System.out.println("dsaf");
//        HashMap<Integer, Integer> haha = new HashMap<>(-1,3);
//        System.out.print(haha);
    }
}
