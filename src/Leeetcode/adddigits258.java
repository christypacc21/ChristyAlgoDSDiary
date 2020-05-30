package Leeetcode;
// https://leetcode.com/problems/add-digits/

//Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
//        Example:
//        Input: 38
//        Output: 2
//        Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
//        Since 2 has only one digit, return it.

//Follow up: Could you do it without any loop/recursion in O(1) runtime?

public class adddigits258 {
    //time O(n)
    //space O(n)
    public static int addDigits_1(int num) {
        int sum = 0;
        while(num != 0){
            sum += num % 10;
            num /= 10;
        }
        if (sum > 10) {
            return addDigits_1(sum);
        } else {
            return sum;
        }
    }
    //        for(int i = 0; i < Integer.toString(num).length(); i++){
    //        }


    //time O(1)
    //space O(1)
    public static int addDigits_2(int num) {
        return (num - 1) % 9 + 1; //不明就背吧
    }
//    1  1
//    2  2
//    3  3
//    4  4
//    5  5
//    6  6
//    7  7
//    8  8
//    9  9
//    10  1
//    11  2
//    12  3
//    13  4
//    14  5
//    15  6
//    16  7
//    17  8
//    18  9
//    19  1
//    20  2



    public static void main(String[] args) {
        System.out.println(addDigits_1(38)); // 2
        System.out.println(addDigits_2(38)); // 2
    }
}
