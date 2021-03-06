package sortAlgorithm;

import java.util.Arrays;

/**
 * --time
 * best O(n) coz has break; | insertionBinarySort(without element shifting) O(nlogn)
 * avg O(n^2)
 * worst O(n^2)
 * --space O(1)
 * --stable
 */

public class InsertionSort {
    // best time O(n) worst time O(n^2) avg time O(n^2), space O(1)
    public static String insertionSort(int[] nums) {
        int temp;

        // i starts at 0, ends at sec last.  j starts at 1 (i+1)
        for (int i = 0; i < nums.length - 1; i++) { // i's end is second last item in the array
            System.out.println("Round i " + (i) + Arrays.toString(nums)); // j's end is the last item in the array
            for(int j = i+1; j > 0; j--) { // nums[0] to nums[j-1] is a sorted sub-array. j is the current item that is going to go into the subarray.
                if (nums[j] < nums[j-1]) { // swap nums[j] and nums[j-1]
                    temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                } else {
                    break; // exits the j forloop coz nums[j] is already moved to the correction position
                }
                System.out.println("Round --- j " + (i) + Arrays.toString(nums));
            }
        }
        return Arrays.toString(nums);
    }

    //?code
    // best time O(nlogn) worst time O(n^2) avg time O(n^2), space O(1)
    public static String insertionBinarySort(int[] nums) {
        int temp; // initialize here instead of inside for loop, to avoid creating new memory space in every loop.
        int low; // (to ensure making space O(n)
        int high; // this is applicable for all code. it is a step that can do at the end.
        int mid; //

        for (int i = 0; i < nums.length - 1; i++) { // for all i < nums.length - 1, why -1 -> coz handling is first loop as base then inner loop(j) is i+1.
            temp = nums[i + 1]; //temp is next item
            low = 0;
            high = i;

            while (low <= high) { // move the left n right n middle pointers until find out the final "high"'s value (the pivot)
                mid = (low + high) / 2;
                if (temp > nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            for (int j = i; j > high; j--) { // move the item to the right one by one, to 清空 a space for the to-be-inserted item
                nums[j + 1] = nums[j];
            }

            nums[high + 1] = temp; // insert the item to the 清空了的位
        }
        return Arrays.toString(nums);
    }

    //?silu ?code
    public static int LC300(int[] nums) { //longest increasing subsequence
        int[] tails = new int[nums.length];
        int size = 0;

        for (int num : nums) {
            int i = 0, j = size;

            while(i != j) {
                int mid = (i + j) / 2;

                if (tails[mid] < num) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            tails[i] = num;
            if (i == size) {
                size++;
            }
        }
        return size;
    }


    public static String insertionBinarySortPrintversion(int[] nums) {
        int temp; // initialize here instead of inside forloop, to avoid creating new memory space in every loop.
        int low; // (to ensure making space O(n)
        int high; // this is applicable for all code. it is a step that can do at the end.
        int mid; //

        for (int i = 0; i < nums.length - 1; i++) { // for all i < nums.length - 1, why -1 -> coz handling is first loop as base then inner loop(j) is i+1.
            System.out.println("Round i " + (i) + Arrays.toString(nums));
            temp = nums[i + 1]; //temp is next item
            low = 0;
            high = i;
            System.out.println("temp="+temp+" low=" +low+" high="+ high);


            while (low <= high) { // move the left n right n middle pointers until find out the final "high"'s value (the pivot)
                mid = (low + high) / 2;
                System.out.println("---while, mid=" + mid);
                if (nums[mid] < temp) {
                    low = mid + 1;
                    System.out.println("-----while a low=" + low);
                } else {
                    high = mid - 1;
                    System.out.println("-----while b high=" + high);
                }
            }

            for (int j = i; j > high; j--) { // move the item to the right one by one, to 清空 a space for the to-be-inserted item
                System.out.println("----------for j=" + j + "  i=" + i);
                nums[j + 1] = nums[j];
            }

            nums[high + 1] = temp; // insert the item to the 清空了的位
            System.out.println("temp="+temp+" low=" +low+" high="+ high);
            System.out.println("Round--------------------- j " + (i) + Arrays.toString(nums));
        }
        return Arrays.toString(nums);
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{5,2,9,4,7,6,1,5,2};
//        System.out.println(insertionSort(nums));
        int[] nums2 = new int[]{1,2,3,0,7,6,1,5,2};
        System.out.println(insertionBinarySort(nums2));
    }


//    public static String insertionSort(int[] nums) {
//        for (int i = 1; i < nums.length - 1; i++) {
//            if (nums[i] < nums[i-1]) {
//
//                for(int j = 0; j < i; j++) {
//                    if (nums[j] < nums[i]) {
//                        int temp = nums[j];
//                        nums[j] = nums[i];
//                        nums[i] = temp;
//                    }
//                }
//            }
//        }
//        return Arrays.toString(nums);
//    }


}
