package Leeetcode;
//https://leetcode.com/problems/longest-increasing-subsequence/
//Given an unsorted array of integers, find the length of longest increasing subsequence.
//
//        Example:
//
//        Input: [10,9,2,5,3,7,101,18]
//        Output: 4
//        Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
//        Note:
//
//        There may be more than one LIS combination, it is only necessary for you to return the length.
//        Your algorithm should run in O(n2) complexity.
//        Follow up: Could you improve it to O(n log n) time complexity?



//tails : []
// res -> represent tails 的 length (final)
// i -> tails 的 起點
// j -> tails 的 終點

public class _300 {
    //time O(nlogn) 最優解
    //space O(n)
    public static int _300(int[] nums){
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums){
            int i = 0, j = res;
            while(i != j){ //insertionsort or what?
                int mid = (i+j) / 2;
                if (tails[mid] < num){
                    i = mid + 1;
                }else{
                    j = mid;
                }
            }
            tails[i] = num;
            if(i == res) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(_300(nums));
    }
}
