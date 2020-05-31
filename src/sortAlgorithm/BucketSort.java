package sortAlgorithm;

//https://www.bilibili.com/video/av17940595/
//https://www.geeksforgeeks.org/bucket-sort-2/

import java.util.*;
//https://www.youtube.com/watch?v=RK9p9BmtOTI
/**  -> a bit like hash table :o (array + linkedinlist)
 * 非比較排序 用空間換時間
 * --time
 * n:待排序的數據 m:桶數量
 * best O(n) //?-> eg [[1],[2],[3],[4]] (each bucket has only i item, make it like a simple array)  //(In interview if ask for O(n)) time, 100% is use bucketsort
 * avg O(n+c) // c = n*(logn ~ logm) (Collections.sort is O(nlogn)) //?-> avg case eg [[1],[2,5,3,7],[3,1],[4,6,7]] -> so time of going thru an array + do sorting in each subarray using Collection.sort
 * worst O(n^2) -> but meaningless coz this method already aims at 用空間換時間, so must better than worst. eg [[,6,7,2,4,56,1,2,3,5,,],[],[],[],[]...]
 * --space O(n + m) // [[x,x,x],[s,d,f],[s,q],...]
 * --stable
 */

public class BucketSort {
    public static void bucketSort(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        // Make buckets
        int bucketNum = (max - min) / nums.length + 1; // + 1 to ensure there is at least 1 bucket (in case the cal result is 0)
        System.out.println("max:" + max +  " min:" + min + " bucketNum : " + bucketNum);
        // 將 外List 初始化
        List<List<Integer>> bucket = new ArrayList<>();
        // 用 forloop 將 內Lists 初始化
        for (int i = 0; i < bucketNum; i++) {
            bucket.add(new ArrayList<>());
        }

        // fun items to each bucket
        for (int i = 0; i < nums.length; i++) {
            int num = (nums[i] - min) / nums.length;
            bucket.get(num).add(nums[i]);
        }

        // do sorting inside each bucket
        for (int i = 0; i < bucket.size(); i++) {
            Collections.sort(bucket.get(i)); //?util
        }
        System.out.println(bucket.toString());
    }

    //?silu ?code
    public static List<Integer> LC347(int[] nums, int k) { // Top K Frequent Elements
        // Do statistics and use HashMap to store them.
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1); // + 1 is to make the default value of that key to 1, instead of 0.
        }
        System.out.println("map: " + map);

        List<Integer>[] bucket = new List[nums.length + 1]; //why + 1 -> coz the array starts from 0. if not +1, the highest num bucket will be missing. eg 5 -> 01234, =! sin wui have 5 (012345).
        for (int num : map.keySet()) {
            int freq = map.get(num);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(num);
        }
        System.out.println("bucket: " + Arrays.toString(bucket));

        List<Integer> res = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
            if(bucket[i] != null) {
                res.addAll(bucket[i]);
            }
        }
        System.out.println("res: " + res);
        return res;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{5,2,9,4,7,6,1,3,8,20,23,21,24};
        bucketSort(nums);
        System.out.println("--------");
        int[] numsLC = new int[]{1,1,1,2,2};
        LC347(numsLC, 2);
    }
}
