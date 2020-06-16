package Leeetcode;

public class _testtwo {
    public static String upOrDown(int[] nums){
        if (nums == null || nums.length < 2){
            return "Invalid input";
        }
        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] < nums[i + 1]){
                return "Ascend";
            } else if (nums[i] > nums[i + 1]) {
                return "Decrease";
            }
        }
        return "May be all items are identical";
    }

    public static void main(String[] args) {
        int[] one = {1,1,1,1,1};
        int[] two = {1,2,3,4,5,6};
        int[] three = {5,4,3,2,1};
        System.out.println(upOrDown(one));
        System.out.println(upOrDown(two));
        System.out.println(upOrDown(three));
    }
}
