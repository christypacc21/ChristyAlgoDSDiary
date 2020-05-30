package sortAlgorithm;

import java.util.Arrays;

public class LC75 {
    // https://blog.csdn.net/fuxuemingzhu/article/details/79392195
    // https://cspiration.com/course/video?id=539

    // ?silu ?code
    public static void LC75(int[] nums) { //Medium | Holland flag
        if (nums == null || nums.length == 0) return;

        int start = 0;
        int end = nums.length - 1;
        int index = 0;
        System.out.println("=========" + Arrays.toString(nums));

        while (index <= end) {
            if (nums[index] == 0) {
                swap(nums, index++, start++);
                System.out.println('a');
            } else if (nums[index] == 1) {
                index++;
                System.out.println('b');
            } else {
                swap(nums, index, end--);
                System.out.println('c');
            }
            System.out.println(Arrays.toString(nums));
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        LC75(nums);
    }
}
