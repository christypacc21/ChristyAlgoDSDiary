package sortAlgorithm;

import java.util.Arrays;

/**
 * --time
 * best (優化後的寫法) O(n)
 * avg O(n^2)
 * worst O(n^2)
 * --space O(1)
 * --stable
 */

public class bubbleSort {

    public static void bubbleSort(int[] nums) {
        for(int i = 0; i < nums.length; i++) { //why no need -1?
            System.out.println("Round i " + (i) + Arrays.toString(nums));
            for(int j = nums.length-1; j > i; j--) {
                if(nums[j] < nums[j-1]) {
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
                System.out.println("Round --- j " + (i) + Arrays.toString(nums));
            }
        }
    }

    public static void bubbleSort_2(int[] nums) {
        boolean flag = false;
        for(int i = 0; i < nums.length; i++) {
            System.out.println("Round i " + (i) + Arrays.toString(nums));
            for(int j = nums.length-1; j > i; j--) {
                if(nums[j] < nums[j-1]) {
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                    flag = true;
                }
                System.out.println("Round --- j " + (i) + Arrays.toString(nums));
            }
            if (!flag) {
                break;
            }
        }
    }

    public static void LC283(int[] nums) {  //Move zero to the end
        if(nums == null || nums.length == 0) {
            return;
        }
        int j = 0; //j ying goy hai trace ju the earliest 0 's position.
        for(int i = 0; i < nums.length; i++) {
            System.out.println("------" + i);
            if(nums[i] != 0) {
                System.out.println(Arrays.toString(nums));
                int temp = nums[i];
                System.out.println(temp);
                nums[i] = nums[j];
                System.out.println(nums[i]);
                nums[j++] = temp;
            }
            System.out.println("j: " + j);
            System.out.println(Arrays.toString(nums));
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{5,2,9,4,7,6,1,3,8};
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
//        int[] nums = new int[]{1,2,3,4,5,7,6,8,9};
//        bubbleSort_2(nums);

//        int[] arr = new int[]{0,1,0,3,12};
        int[] arr = new int[]{0,1,3,12,0,0,5,8,0,9};
//        int[] arr = new int[]{0,1,0,3,12,1,45,0,0,4,7,0,1,0,0,23,6,7,8,8,3};
        LC283(arr);
    }


}
