package Leeetcode;
//https://leetcode.com/problems/top-k-frequent-elements/
//Given a non-empty array of integers, return the k most frequent elements.
//        Example 1:
//        Input: nums = [1,1,1,2,2,3], k = 2
//        Output: [1,2]

//        Example 2:
//        Input: nums = [1], k = 1
//        Output: [1]

//        Note:
//        You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
//        Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
//        It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
//        You can return the answer in any order.

// * Note that this question needs clarification with interviewer. What is K ? when k = 2 but turns out actually has > 2 (eg 3), which item should i return? (eg according to priority or return all 3?)

import java.util.*;
/**
 * for all 3 methods:
 *
 * [1,1,1,2,2,3,3,4] length = 8
 *
 * HashMap:
 * num : freq
 *   1 : 3
 *   2 : 2
 *   3 : 2
 *   4 : 1
 */
public class _347 { //super important, Must 熟
    // (Must 熟) M1 Priority queue : time O(n logn) space O(n) //? coz not yet learnt this // 时间复杂度，在加入时为 O(nlogn)，但是在poll出来时为 O(klogn)，总的应该取最坏情况 O(nlogn)
    public static List<Integer> _1(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); // 用HashMap
        for (int num : nums){ //construct the hashmap (the statistics) (num: freq)
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            maxHeap.add(entry);
        }

        List<Integer> res = new ArrayList<>();
        while (res.size() < k){
            Map.Entry<Integer, Integer> entry = maxHeap.poll(); // get the max item(s) out // everytime poll uses O(logn) time.
            res.add(entry.getKey());
        }
        return res;
    }

    /**
     * frequent [0,1,2,3,4,5,6,7,8]
     */
    // (Must 熟) M2 Bucket sort : time : O(n) space O(n)
    public static List<Integer> _2(int[] nums, int k) {
        // Step1(HashMap) build a raw set of frequency statistics using datastructure HashMap {item:frequency, item:frequency, ...}
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1); // if no this record, create a record as key and 1 as value ; if has record, plus one to the value of the key.
        }

        // Step2(Bucket sort) build a new set of frequency statistics using buckets (position implies frequency:[0,1,2,3,4...]) -> data:[null,[4],[2,3],[1],null...]
        List<Integer>[] bucket = new List[nums.length + 1]; // the position 0 in bucket is not useful, so need to + 1 (16:10 in video)
        for (int num : map.keySet()){
            int freq = map.get(num);
            if (bucket[freq] == null){
                bucket[freq] = new LinkedList<>();
            }
            bucket[freq].add(num);
        }
        System.out.println(Arrays.toString(bucket));

        // Step3(ArrayList as result) construct the result(an array) using the buckets' statistics
        List<Integer> res = new ArrayList<>();
        // if clarified with interviewer what k should return:
        // choice 1 -> return all items that satisfy k (eg k = 2, output is [1,2,3])
        for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--){
            if (bucket[i] != null){
                res.addAll(bucket[i]);
            }
        }
        // choice 2 -> return only k items. (eg k = 2, output is [1,2])
//        for (int i = bucket.length - 1; i >= 0; i--){
//            int j = 0;
//            while (bucket[i] != null && j < bucket[i].size() && k > 0){
//                res.add(bucket[i].get(j++));
//                k--;
//            }
//        }
        return res;
    }

    /**
     * freqMap :
     * 3 : 1
     * 2 : 2,3
     * 1 : 4
     */
    // M3 TreeMap (紅黑樹) : time O(n logn) space O(n) // 时间复杂度，在加入时为 O(nlogn)，但是在poll出来时为 O(klogn)，总的应该取最坏情况 O(nlogn)
    public static List<Integer> _3(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); // 用HashMap
        for (int num : nums){ //construct the hashmap (the statistics) (num: freq)
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
        for (int num : map.keySet()){
            int freq = map.get(num);
            if (freqMap.containsKey(freq)) {
                freqMap.get(freq).add(num);
            } else {
                freqMap.put(freq, new LinkedList<>());
                freqMap.get(freq).add(num);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (res.size() < k){
            Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry(); // get the max item(s) out // everytime poll uses O(logn) time.
            res.addAll(entry.getValue());
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,1,1,2,2,3,3,4};
        System.out.println(_1(nums1, 2));
        int[] nums2 = {1,1,1,2,2,3,3,4};
        System.out.println(_2(nums2, 2));
        int[] nums3 = {1,1,1,2,2,3,3,4};
        System.out.println(_3(nums3, 2));
    }

}
