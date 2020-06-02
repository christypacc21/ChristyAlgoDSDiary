package searchAlgorithm;


import java.lang.reflect.Array;
import java.util.Arrays;

public class BinarySearch {
    //Lsn 5-2 递归写法 tO(logn) sO(logn)
    public static int binarySearch(int[] nums, int low, int high, int target){
        if(high < low){ // rmb don't use <= here, coz there may be case when nums.length = 1.
            return -1;
        }

        int mid = (high - low)/2 + low;

        if (nums[mid] > target) {
            return binarySearch(nums, low, mid - 1, target);
        } else if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, high, target);
        } else { // nums[mid] == target
            return mid;
        }
    }

    //Lsn 5-3 iteration 写法 I：left <= right
    public static int binarySearch1(int[] nums,  int target){
        int left = 0;
        int right = nums.length - 1; //[left, right]
        while (left <= right) { // (結束條件 will be : right < target < left , right + 1 = left;)
            int mid = (right - left)/2 + left;
            if (nums[mid] > target){ // [left, mid - 1]
                right = mid - 1;
            } else if (nums[mid] < target){ // [mid + 1, right]
                left = mid + 1;
            } else {
                return mid;
            }
            System.out.println("mid: " + nums[mid] + " left: " + nums[left] + " right: " + nums[right]);
        }
        System.out.println("I) left : " + left + " right : " + right);
        return -1;
    }

    //Lsn 5-4 iteration 写法 II : left < right
    public static int binarySearch2(int[] nums,  int target){
        int left = 0;
        int right = nums.length; //[left, right)
        while (left < right) { // (left = right 不執行) (結束條件 : target < left = right, left = right)
            int mid = (right - left)/2 + left;
            if (nums[mid] > target){ // [left, mid）
                right = mid;
            } else if (nums[mid] < target){ // [mid + 1, right）
                left = mid + 1;
            } else {
                return mid;
            }
            System.out.println("mid: " + nums[mid] + " left: " + nums[left] + " right index: " + right);
        }
        System.out.println("II) left : " + left + " right : " + right);
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,9,10};
        System.out.println(Arrays.toString(nums) + " target: 6");
        System.out.println(binarySearch2(nums, 6));
    }
}
