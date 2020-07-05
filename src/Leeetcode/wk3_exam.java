package Leeetcode;
//        You are given a char array representing tasks CPU need to do.
//        It contains numbers where each number represents a different task.
//        Tasks could be done without the original order of the array.
//        Each task is done in one unit of time.
//        For each unit of time, the CPU could complete either one task or just be idle.
//
//        However, there is a non-negative integer n that represents the cooldown period between two same tasks
//        (the same letter in the array), that is that there must be at least n units of time between any two same tasks.
//
//        You need to return the least number of units of times that the CPU will take to finish all the given tasks.
//
//        Example 1:
//
//        Input: tasks = [1, 2, 1, 3, 8, 99], n = 2
//        Output: 7
//        Explanation:
//        1 -> 2 -> idle -> 1 -> 3 -> 8 -> 99
//        There is at least 2 units of time between any two same tasks.

import java.util.HashMap;

public class wk3_exam { // Ding, used me 1hr 45 min =='

    public static int lc(int[] nums, int n){ // time : O(n) | space: O(n)
        if (nums == null || nums.length == 0) return 0;
        if (n <= 0) return 0;

        HashMap<Integer, Integer> map= new HashMap<>(); //<num: position(ie i)>
        int res = 0;

        for (int i=0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) < n + 1) { // supposingly, i - map.get(nums[i]) >= n + 1 (ie should 隔至少 n + 1 of i)
                    res += (map.get(nums[i]) + (n+1) - i + 1);
                } else {
                    res += 1;
                }
            } else {
                res += 1;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {1,2,1,3,8,99}; //if n = 2, shd be 7 | if n = 3, shd be 8
//        int[] nums = {1,2,1,3,8,99,8,1}; // if n = 2, shd be 10 | if n = 3, shd be 12
//        int[] nums = {1,2,1,3,8,99,14,8,1}; // if n = 2, shd be 10 | if n = 3, shd be 12
//        int[] nums = {1}; // shd be 1
        int[] nums = {1,1,1}; //if n = 2, shd be 7 | if n = 3, shd be 9
        System.out.println(lc(nums, 3));
    }
}



//    public static int lc(int[] nums, int n){
//        if(nums == null || nums.length == 0) return 0;
//        if(n <= 0) return 0;
//
//        int res = 0;
//        HashSet<Integer> set= new HashSet<>();
//        for(int num : nums){
//            if(set.contains(num)){
//                res += n;
//            } else {
//                set.add(num);
//                res ++;
//            }
//        }
//        return res;
//    }




//    public static int lc(int[] nums, int n){
//        if(nums == null || nums.length == 0) return 0;
//        if(n <= 0) return 0;
//
//        HashMap<Integer, Integer> map= new HashMap<>(); //<num: position(ie i)>
//        int res = 0;
//
//        for(int i=0; i < nums.length; i++){
//            if (map.containsKey(nums[i])){
//                //check last nums[i]'s i
//                //if last i + n > i -> res += n,
//                //else -> res += 1
//
////                //update key's value to current i
////                map.put(nums[i], i);
//            } else {
////                map.put(nums[i], i);
//                res += 1;
//            }
//
//            map.put(nums[i], i);
//        }
//        return res;
//    }



// make {1,1,1} 7 instead of 9
//    public static int lc(int[] nums, int n){ // time : O(n) | space: O(n)
//        if(nums == null || nums.length == 0) return 0;
//        if(n <= 0) return 0;
//
//        HashMap<Integer, Integer> map= new HashMap<>(); //<num: position(ie i)>
//        int res = 0;
//
//        for(int i=0; i < nums.length; i++){
//            if (map.containsKey(nums[i])){
//                if(map.get(nums[i]) + 1 + n > i){ // +1 here, because start from 0
//                    res += n;
//                } else {
//                    res += 1;
//                }
//            } else {
//                res += 1;
//            }
//
//            map.put(nums[i], i);
//        }
//        return res;
//    }



//    public static int lc(int[] nums, int n){ // time : O(n) | space: O(n)
//        if(nums == null || nums.length == 0) return 0;
//        if(n <= 0) return 0;
//
//        HashMap<Integer, Integer> map= new HashMap<>(); //<num: position(ie i)>
//        int res = 0;
//
//        for(int i=0; i < nums.length; i++){
//            if (map.containsKey(nums[i])){
//                if(i - map.get(nums[i]) < n + 1){ // suppose i - map.get(nums[i]) >= n + 1 (suppose should 隔至少 n + 1 of i)
////                    res += n;
////                    res += ((i-1)-map.get(nums[i]) + n);
////                    res += (Math.abs(map.get(nums[i]) - i) + n);
////                    int cha = Math.abs(map.get(nums[i]) - i);
////                    int haha = (res - cha + n);
////                    int newnew = res - (i - map.get(nums[i]) - 1) + n;
////                    int newnew = n - (i - map.get(nums[i]) - 1);
//                    int newnew = map.get(nums[i]) + n - i + 1;
//                    res += newnew;
//                } else {
//                    res += 1;
//                }
//            } else {
//                res += 1;
//            }
//
//            map.put(nums[i], i);
//        }
//        return res;
//    }


// ho chi duc jor
//public class wk3_exam {
//
//    public static int lc(int[] nums, int n){ // time : O(n) | space: O(n)
//        if(nums == null || nums.length == 0) return 0;
//        if(n <= 0) return 0;
//
//        HashMap<Integer, Integer> map= new HashMap<>(); //<num: position(ie i)>
//        int res = 0;
//
//        for(int i=0; i < nums.length; i++){
//            if (map.containsKey(nums[i])){
//                if(i - map.get(nums[i]) < n + 1){ // suppose i - map.get(nums[i]) >= n + 1 (suppose should 隔至少 n + 1 of i)
////                    res += n;
////                    res += ((i-1)-map.get(nums[i]) + n);
////                    res += (Math.abs(map.get(nums[i]) - i) + n);
////                    int cha = Math.abs(map.get(nums[i]) - i);
////                    int haha = (res - cha + n);
////                    int newnew = res - (i - map.get(nums[i]) - 1) + n;
////                    int newnew = n - (i - map.get(nums[i]) - 1);
//                    System.out.println(map.get(nums[i]));
//                    System.out.println(n);
//                    System.out.println(i);
//                    System.out.println("========");
//
//                    int newnew = map.get(nums[i]) + (n+1) - i + 1;
//                    res += newnew;
//                } else {
//                    res += 1;
//                }
//            } else {
//                res += 1;
//            }
//
//            map.put(nums[i], i);
//        }
//        return res;
//    }