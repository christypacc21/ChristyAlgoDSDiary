package sortAlgorithm;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

/**
 * --time
 * best O(n^2)
 * avg O(n^2)
 * worst O(n^2)
 * --space O(1)
 * -- NOT stable
 */


public class SelectionSort {
    public static String selectionSort(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;

            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }

            if(minIndex != i){
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
        return Arrays.toString(nums);
    }


    public static boolean LC334(int[] nums) { // Increasing Triplet Subsequence
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;

        for(int num: nums) {
            if(num <= min) {
                min = num;
            } else if (num < secondMin) {
                secondMin = num;
            } else if (num > secondMin) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,9,4,7,6,1,5,2};
        System.out.println(selectionSort(nums));
        int[] nums2 = new int[]{5,2,9,4,7,6,1,5,2};
        System.out.println(LC334(nums2));
    }
}
