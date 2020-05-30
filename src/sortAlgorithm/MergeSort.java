package sortAlgorithm;

import java.util.Arrays;

/**
 * --time
 * best O(nlogn) coz has break; | insertionBinarySort(without element shifting) O(nlogn)
 * avg O(nlogn)
 * worst O(nlogn)
 * --space O(n) (**NOT O(logn), coz every merge we make some new variables) (?)
 * --stable
 */


// https://www.bilibili.com/video/BV1Ax411U7Xx/?spm_id_from=333.788.videocard.0

public class MergeSort {
    //?code
    public static int[] mergeSort(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
        return nums;
    }

    public static void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (nums[i] <nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= high) {
            temp[k++] = nums[j++];
        }
        for (int x = 0; x < temp.length; x++) {
            nums[x + low] = temp[x];
        }
        System.out.println("----end" + Arrays.toString(temp));
    }
    //?code
    // https://www.youtube.com/watch?v=YXOBpf75R0Y (JS)
    public static int[] LC88(int[] nums1, int m, int[] nums2, int n) { // Merge sorted array
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
        return nums1;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{5,2,9,4,7,6,1,5,2};
//        System.out.println(Arrays.toString(mergeSort(nums, 0, nums.length-1)));
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        System.out.println(Arrays.toString(LC88(nums1, 3, nums2, 3)));
    }
}
