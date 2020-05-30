package Leeetcode;

import java.util.HashMap;
//https://www.youtube.com/watch?v=2MmGzdiKR9Y
//https://www.youtube.com/watch?v=xa_60srQAKo
//https://www.youtube.com/watch?v=l5fw70Sw62I
//https://www.youtube.com/watch?v=aYfwus5T3Bs
//https://www.youtube.com/watch?v=lDIepJ-raTQ
public class _325 {
    //time O(n) , space O(n)
    public static int _325(int[] nums, int k){
        if(nums == null || nums.length == 0) return 0;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); // to store the statistics
        map.put(0, -1); //important

        // calculate the 前綴和
        for(int i = 1; i < nums.length; i++){
            nums[i] += nums[i - 1];
        }

        //
        for (int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i] - k)){
                res = Math.max(res, i - map.get(nums[i] - k));
            }
            if (!map.containsKey(nums[i])){
                map.put(nums[i], i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, 5, -2, 3};
        System.out.println(_325(nums, 3));
    }
}
