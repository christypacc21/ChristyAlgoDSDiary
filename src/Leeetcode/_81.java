package Leeetcode;

// 4 5 6 7 0 1 2
// 4 5 6 0 1 2 3
// 1 1 1 3 1

public class _81 {
    public static boolean lc(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = (end - start)/2 + start;
            if(nums[mid] == target){ // [mid]
                return true;
            }

            if(nums[start] == nums[mid] && nums[mid] == nums[end]){
                start++;
                end--;
            } else if (nums[start] <= nums[mid]){ //可能性1 - 左邊是順序 (轉折位在右)  //if
                if(target < nums[mid] && target >= nums[start]){ // if target falls on the left
                    end = mid - 1; // 縮小範圍到左邊only
                } else {
                    start = mid + 1;
                }
            } else { //nums[mid] <= nums[end] // 可能性2 - 右邊是順序 (轉折位在左） //else if
                if (target > nums[mid] && target <= nums[end]){ // if target falls on the right
                    start = mid + 1; // 縮小範圍到右邊only
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(lc(nums, 0));
        int[] nums2 = {4,5,6,0,1,2,3};
        System.out.println(lc(nums2, 5));
    }
}
