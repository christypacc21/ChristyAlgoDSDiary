package Leeetcode;

import java.util.ArrayList;
import java.util.List;

public class _163 { //tO(n) sO(n)
    public static List<String> lc(int[] nums, int lower, int upper){
        List<String> res = new ArrayList<>();
        long alower = (long)lower, aupper = (long)upper;
        for (int num : nums){
            if (num == alower){
                alower++;
            } else if (alower < num){
                if (alower + 1 == num){
                    res.add(String.valueOf(alower));
                } else {
                    res.add(alower + "->" + (num - 1));
                }
                alower = (long)num + 1;
            }
        }
        if (alower == aupper) res.add(String.valueOf(alower));
        else if (alower < aupper) res.add(alower + "->" + aupper);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,3,50,75};
        System.out.println(lc(nums,0,99));
        int[] nums1 = {2147483647};
        System.out.println(lc(nums1,0,2147483647));
    }
}