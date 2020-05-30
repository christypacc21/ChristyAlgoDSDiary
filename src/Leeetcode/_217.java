package Leeetcode;

import java.util.Arrays;
import java.util.HashSet;

public class _217 {
    public static boolean ls(int[] nums){ //time O(n) space O(n)
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            if(!set.add(nums[i])) return true;
        }
        return false;
    }

    public static boolean ls2(int[] nums){ //time O(nlogn) space O(1)
        Arrays.sort(nums); // time O(nlog
        for(int i = 0 ; i < nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
