package Leeetcode;

import java.util.Arrays;

//Easy
//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
//
//        Note:
//
//        The number of elements initialized in nums1 and nums2 are m and n respectively.
//        You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
//        Example:
//
//        Input:
//        nums1 = [1,2,3,0,0,0], m = 3
//        nums2 = [2,5,6],       n = 3
//
//        Output: [1,2,2,3,5,6]

public class _88 {
    //timeO(m+n) spaceO(1)
    public static int[] _88(int[] nums1, int m, int[] nums2, int n){
        // Note that the input provided to us are SORTED arrays!
        int i = m - 1; // array1 last item position
        int j = n - 1; // array2 last item position
        int k = m + n - 1; // final array1's last item's position

        while (i >= 0 && j >= 0) { // if both input array's items both not yet finished processing // mainly handle i
            // compare the two input array's last item(i and j), append the bigger one to nums1. Note that to save space, we do not create a third array, instead we use nums1 array to hold the final result.
            nums1[k--] = nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (j >= 0) { // after finished handling i things, needa handle j -why it works?-> mainly handle j (Also, to avoid edge case : [0]0[1]1)
            nums1[k--] = nums2[j--];
        }
        return nums1;
    }

    public static void main(String[] args) {
//        int[] nums1 = new int[]{3,4,5,0,0,0};
//        int[] nums2 = new int[]{1,2};

//        int[] nums1 = new int[]{1,2,0,0,0,0};
//        int[] nums2 = new int[]{3,4,5,6};

        int[] nums1 = new int[]{5,6,0,0,0,0};
        int[] nums2 = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(_88(nums1, 2, nums2, 4)));
    }
}
