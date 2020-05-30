package Leeetcode;

import java.util.HashMap;

//https://leetcode.com/problems/contains-duplicate-ii/submissions/
//219. Contains Duplicate II
//Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
//Example 1:
//Input: nums = [1,2,3,1], k = 3
//Output: true

public class _219 {
    //time O(n) space O(n)
    public static boolean lc(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>(); //{nums[i]: i}
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k){
                    return true;
                }
            }
            map.put(nums[i],i); // to add the new item / update the existing item //Hashmap.put -> This means we can insert a specific key and the value it is mapping to into a particular map. If an existing key is passed then the previous value gets replaced by the new value. If a new pair is passed, then the pair gets inserted as a whole. // Return Value: If an existing key is passed then the previous value gets returned. If a new pair is passed, then NULL is returned.// https://www.geeksforgeeks.org/hashmap-put-method-in-java/
        }
        return false;
    }
}




    // self do, not yet success but almost haha
//    public static boolean lc(int[] nums, int k){
//        // if(nums == null || nums.length == 0) return false;
//        int max = 0;
//        HashMap<Integer, Integer> map = new HashMap<>(); //{nums[i]: i}
//        for(int i = 0; i < nums.length; i++) {
//            if (map.containsKey(nums[i])) {
//                //check if in there, then check the distance of i and the value, then compare MAX with max
//                max = Math.max(nums[i] - map[i]);
//                map[i] = i;
//            } else {
//                // add this item to hashmap
//                map.put(nums[i], i);
//            }
//        }
//    }
