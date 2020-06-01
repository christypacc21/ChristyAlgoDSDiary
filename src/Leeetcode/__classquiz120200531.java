package Leeetcode;

public class __classquiz120200531 { // timeO(n) spaceO(1)
    public static int countNumOfThree(int n){
        if (n < 0) return 0;

        int res = 0;
        for (int i = 0; i <= n; i++){
            res += count3(i);
        }
        return res;
    }

    public static int count3(int num){
        int count = 0;
        while (num != 0){
            if( num % 10 == 3) count++;
            num /= 10;
        }
        return count;
    }

    public static void main (String args[]) {
        int num = 30;
        System.out.println(countNumOfThree(num));
    }

//    public static int countNumOfThree(int[] nums, int n){
//        if(nums == null || nums.length == 0) return -1;
//        int res = 0;
//        for (int i = 0; i < nums.length; i++){
//            res += count3(nums[i]);
//        }
//        return res;
//    }
//
//    public static int count3(int num){
//        int count = 0;
//        while (num != 0){
//            if( num % 10 == 3) count++;
//            num /= 10;
//        }
//        return count;
//    }
//
//    public static void main (String args[]) {
//        int[] nums = {3,13, 23, 30, 33, 66, 13, 3, 35, 3333, 0};
//        System.out.println(countNumOfThree(nums, 4));
//    }
}
