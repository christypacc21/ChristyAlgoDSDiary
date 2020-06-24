package Leeetcode;

//[LeetCode] 246. Strobogrammatic Number 对称数
//
//        A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
//
//        Write a function to determine if a number is strobogrammatic. The number is represented as a string.
//
//        Example 1:
//
//        Input:  "69"
//        Output: true
//        Example 2:
//
//        Input:  "88"
//        Output: true
//        Example 3:
//
//        Input:  "962"
//        Output: false

import java.util.HashMap;

public class _246 {
    public static boolean lc(String num){
        HashMap<Character, Character> map = new HashMap<>();
        map.put('6','9');
        map.put('9','6');
        map.put('1','1');
        map.put('8','8');
        map.put('0','0');

        int i=0;
        int j=num.length()-1;
        while(i<=j){
            char start = num.charAt(i);
            char end = num.charAt(j);
            i++;
            j--;
            if(map.containsKey(start) && map.get(start) == end){
                continue;
            }
            return false;
//            if(!map.containsKey(start) || map.get(start) != end){ // christy
//                return false;
//            }
        }
        return true;
    }

    public static void main(String[] args) {
        String num = "89169168"; //true
        String num2 = "690819680189"; //false
        System.out.println(lc(num));
        System.out.println(lc(num2));
    }
}



//
//    HashMap<Character, Character> map = new HashMap<>();
//        map.put('6','9');
//                map.put('9','6');
//                map.put('0','0');
//                map.put('1','1');
//                map.put('8','8');
//
//                int left = 0;
//                int right = num.length() - 1;
//                while(left <= right){ //in this question,  does < vs <= matter?
//                if(!map.containsKey(num.charAt(left))){
//                return false;
//                }
//                if(!map.containsKey(num.charAt(right))){
//                return false;
//                }
//                left++;
//                right--;
//                }
//                return true;
