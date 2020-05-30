package Leeetcode;

//https://cspiration.com/course/video?id=1561
//https://segmentfault.com/a/1190000003817671

public class _287 {

    //time O(nlogn) space O(1)
    public static int _287(int[] nums){ //?
        int min = 0;
        int max = nums.length - 1;
        while(min <= max){
            int mid = (max - min) / 2 + min;
            int count = 0;
            for (int i = 0; i < nums.length; i++){ // coz nums may not be sorted
                if (nums[i] <= mid){
                    count++;
                }
            }
            if (count > mid){
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min; // this line me just chose a variable that can return the correct answer, dunno the returned stuff is min or not actually/
    }

    // time O(n) | spaceO (1)
    // 142 linked list cycle II
    // slow fast
    public static int _287_2(int[] nums){ //?
        int slow  = nums[0];
        int fast = nums[nums[0]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {6,1,5,2,3,1,4};
        int[] nums2 = {3,1,3,4,2};
        System.out.println(_287(nums));
        System.out.println(_287(nums2));
        int[] nums3 = {1,3,4,2,2};
        System.out.println(_287_2(nums3));
    }

}
