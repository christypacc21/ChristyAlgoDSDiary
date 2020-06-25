package sortAlgorithm;

import java.util.Arrays;

public class HeapSort {
    public static void heapSort(int[] nums){
        for (int i = (nums.length - 1) / 2; i >= 0; i--){
            heapAdjust(nums, i, nums.length);
        }
        System.out.println(Arrays.toString(nums));
        for (int i = nums.length - 1; i > 0; i--){
            swap(nums, 0, i);
            heapAdjust(nums, 0, i);
        }
    }

    // becareful of node position in array VS node's value
    public static void heapAdjust(int[] nums, int start, int length){ //basically same logic as siftdown() / siftDownHeapify()
        int child = 2 * start + 1; // calculate and get leftnode
        while (child < length){ // if have child node
            if (child + 1 < length && nums[child] < nums[child + 1]){ //if has right child and right child value bigger than left child value
                child++; // now right child is the biggest value node.
            }
            if (nums[start] < nums[child]){ // if current node is smaller than the biggest childnode , swap them two.
                swap(nums, start, child);
            } else { // if not, then means its position is correct (ref: maxheap's properties) already, no need further move.
                break;
            }
            start = child;
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,23,30,8,32,31,41,1,15};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
