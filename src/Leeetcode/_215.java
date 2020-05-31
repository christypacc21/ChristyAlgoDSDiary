package Leeetcode;
// https://leetcode.com/problems/kth-largest-element-in-an-array/submissions/

import java.util.PriorityQueue;

public class _215 {
    // M1 (cson gong duc gei ho, can watch a few more times or run case or practice more if not yet familiar) https://cspiration.com/course/video?id=1566
    public static int lc_quicksort(int[] nums, int k){ // cson here uses iteration but not recursion, just personal preference
        // time O(n) space O(1)
        if (nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = nums.length - 1;
        while (true){ // repeat until something is returned.
            int pos = partition(nums, left, right);
            if (pos + 1 == k){ // coz pos starts from 0, so needa + 1 == k
                return nums[pos];
            } else if (pos + 1 > k){
                right = pos - 1;
            } else {
                left = pos + 1;
            }
        }
    }

    private static int partition (int[] nums, int left, int right){ //important - learn how it handle the movement (pay special attention to the last step od sorting)
        // Note that we want to sort the array from left to right to be big to small. (coz later we choose to loop from i=0 i++ (left to right) to find out the result(ie kth largest element))
        int pivot = nums[left]; // cson personal preference : use the leftmost item as quicksort's pivot (vs normally people uses random instead)
        int l = left + 1; // + 1 is coz the leftmost item is used at pivot, so should not included in the following sorting.
        int r = right;
        while (l <= r) {
            if(nums[l] < pivot && nums[r] > pivot){
                swap (nums, l++, r--);
            }
            if (nums[l] >= pivot) l++; // correctly placed, dun need to swap
            if (nums[r] <= pivot) r--; // correctly placed, dun need to swap
        }
        swap(nums, left, r); // swap the pivot to put the pivot to the correct location that he should be in(its left must be items that larger than it, its right shd be smaller than him), after the above sorting.
        return r;
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // M2 time O(nlogk)(everytime we .offer(), prorityqueue will sort for once) ?why logk?  | space O(n)
    public static int lc_priorityQueue(int[] nums, int k){
        if (nums == null || nums.length == 0) return 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num); // put the item into PriorityQueue
            if (minHeap.size() > k) {
                minHeap.poll(); // .poll() -> pop out the smallest item
            }
        }
        return minHeap.poll();
    }

    public static void main(String[] args) {
        int[] nums1 = {3,2,3,1,2,4,5,5,6};
        System.out.println(lc_quicksort(nums1, 4));
        int[] nums2 = {3,2,3,1,2,4,5,5,6};
        System.out.println(lc_priorityQueue(nums2, 4));
    }
}
