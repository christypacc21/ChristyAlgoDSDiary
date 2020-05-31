package Leeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15 {
    // time O(n^2)    space O(n^2)(2d array)
    public static List<List<Integer>> lc(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;

        Arrays.sort(nums); // Sort the array first (for us to find duplicated items later easily)

        for (int i = 0; i < nums.length - 2; i++){ // -2 coz do 3sum
            if (i > 0 && nums[i] == nums[i - 1]) continue; //ignore the repeated item
            int low = i + 1; // + 1 coz 2sum
            int high = nums.length - 1;
            int sum = 0 - nums[i];
            while (low < high){ // do 2sum //*** here is time O(n^2)!!!
                if (nums[low] + nums[high] == sum){
                    res.add(Arrays.asList(nums[i], nums[low], nums[high])); //add this ok combintation eg [-1,2,3] into the big result array
                    while (low < high && nums[low] == nums[low + 1]) low++; //ignore the repeated item
                    while (low < high && nums[high] == nums[high - 1]) high--; //ignore the repeated item
                    low++;
                    high--;
                } else if (nums[low] + nums[high] < sum){
                    low++;
                } else {
                    high--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(lc(nums));
    }
}
