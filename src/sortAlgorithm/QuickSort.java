package sortAlgorithm;

import java.util.Arrays;

/**
 * --time
 * best O(nlogn) (分治法）
 * avg O(nlogn)
 * worst O(n^2)  (when array is totally reversed)
 * --space : within O(logn) and O(n)
 * --NOT stable
 */

public class QuickSort {
    //?code
    public static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivot = partition(nums, left, right);
            quickSort(nums, left, pivot - 1);
            quickSort(nums, pivot + 1, right);
        }
    }

    public static int partition(int[] nums, int left, int right) { //what is partition here?
        int pivotIndex = left;
        int pivot = nums[pivotIndex];
        int l = left + 1;
        int r = right;
        System.out.println("pivot : " + pivot + " " + Arrays.toString(nums));
        System.out.println("pivotIndex : " + pivotIndex + " " + "l=" + l + " r=" + r);

        while(l <= r) {
            if (nums[l] > pivot && nums[r] < pivot) {
                swap(nums, l++, r--);
            }
            if (nums[l] <= pivot) l++;
            if (nums[r] >= pivot) r--;
            System.out.println("當前結果 : " + Arrays.toString(nums));
        }

        swap(nums, pivotIndex, r);
        System.out.println("--------------- 此輪結果 : " + Arrays.toString(nums));
        return r;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    // ?silu ?code
    // LC215 Kth largest element in an array (quick select)
    public static int LC215(int[] nums, int k) {  //?what is k
        if (nums == null || nums.length == 0)  return 0;
        int left = 0;
        int right = nums.length - 1;
        while(true) {
            int pos = partitionLC215(nums, left, right);
            if (pos + 1 == k) {
                return nums[pos];
            } else if (pos + 1 > k) {
                right = pos - 1;
            } else {
                left = pos + 1;
            }
        }
    }

    public static int partitionLC215(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1;
        int r = right;

        while(l <= r) {
            if (nums[l] < pivot && nums[r] > pivot) {
                swap(nums, l++, r--);
            }
            if (nums[l] >= pivot) l++;
            if (nums[r] <= pivot) r--;
        }

        swapLC215(nums, left, r);
        return r;
    }

    public static void swapLC215(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
//        int[] nums = new int[]{5,2,9,4,7,6,1,5,2};
        int[] nums = new int[]{2,0,2,1,1,0};
        quickSort(nums, 0, nums.length - 1);

//        int[] nums1 = new int[]{3,2,3,1,2,4,5,5,6};
//        System.out.println(LC215(nums1,  4));
    }
}
