package Leeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an array nums of n integers and an integer target, are there elements a, b, c,
// and d in nums such that a + b + c + d = target?
// Find all unique quadruplets in the array which gives the sum of target.
//        Note:
//        The solution set must not contain duplicate quadruplets.
//
//        Example:
//        Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
//        A solution set is:
//        [
//          [-1,  0, 0, 1],
//          [-2, -1, 1, 2],
//          [-2,  0, 0, 2]
//        ]

public class _18 { // basically the same as LC15 threeSum
    public static List<List<Integer>> lc(int[] nums, int target) { //time O(n^3) space O(10
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) return res;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++){
            if (i > 0 && nums[i] == nums[i-1]) continue; //ignore the duplicated
            for (int j = i + 1; j < nums.length - 2; j++){
                if (j > i + 1 && nums[j] == nums[j-1]) continue; //ignore the duplicated
                int low = j + 1;
                int high = nums.length - 1;
                while (low < high) {
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) low++; //ignore the duplicated
                        while (low < high && nums[high] == nums[high - 1]) high--; //ignore the duplicated
                        low++;
                        high--;
                    } else if (sum < target){
                        low++;
                    } else high--;
                }
            }
        }
        return res;
    }

    public static void print(List<List<Integer>> res){
        System.out.println(Arrays.toString(res.toArray()));
//        for(int i = 0; i < res.size(); i--){
//            System.out.println(Arrays.toString(res.get(i)));
//        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        print(lc(nums, 0));
    }
}
