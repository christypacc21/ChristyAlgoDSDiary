package sortAlgorithm;

import java.util.Arrays;

/**  -> make a new array to store statistics
 * 非比較排序 用空間換時間
 * --time
 * best O(n) //? -> if max = nums.length and nums裡沒有一個數是重複的 , which can achieve O(n+n) time which = O(n)
 * avg O(n + k) n is number of item in the original array | k is 整數的範圍 (the "max"+1 below) (or say range of input))
 * worst meaningless
 * --space : O(k) (Ting: k is the Max_Value + 1 in the array. eg [0,2,1,8] , the array "count" will be [0,1,1,0,0,0,0,0,1] | k = 9 )
 * --stable
 */

//The problem with the previous counting sort was that we could not sort the elements if we have negative numbers in it. Because there are no negative array indices. So what we do is, we find the minimum element and we will store count of that minimum element at zero index.

// https://www.youtube.com/watch?v=7zuGmKfUt7s
// https://www.youtube.com/watch?v=OKd534EWcdk
// https://www.youtube.com/watch?v=TTnvXY82dtM

public class CountSort {
    public static void countSort(int[] nums) {
        // 看看等一下要開闢多少個空間（here 找items之中最大的數for later use）
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        // make a new array called "count", to store the statistics.
        int[] count = new int[max + 1]; //[max + 1] coz include mai 0 to the array. eg max is "8", then array length should be 9 (coz 012345678)
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]] = count[nums[i]] + 1; // +1 to the 格仔
        }
        System.out.println(Arrays.toString(count));

        int index = 0;
        for (int i = 0; i <= max; i++) { // for each location in the array //?how to calculate the time complexity here
            for (int j = 0; j < count[i]; j++) { // add the to item into res array by using the frequency statistics
                nums[index++] = i;
            }
        }
        System.out.println(Arrays.toString(nums));
    }


    public static int LC387(String s) { // Easy | First unique character in a string
        int[] count = new int[26]; // "count"'s size is k. Do and store the statistic results in "count".
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++; // why -'a' -> it "shifts" the ascii/unicode value so that A - Z have values 0-25 instead of 1-26. And are thus more suitable as an array index. https://stackoverflow.com/questions/8118802/what-exactly-does-arrays-charati-a-do
        }
        for (int i = 0; i < s.length(); i++) { // loop through the input(ie s). See which item in the input first hv a 1 frequency in "count".
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{0,5,2,9,4,7,6,1,3,8};
//        int[] nums = new int[]{1,0,3,1,3,1};
//        countSort((nums));
        String string = new String("leetcodelll");
        System.out.println(LC387(string));
    }
}
