package Leeetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _3 {
    ////Approach 2: Sliding Window
//    public static int lengthOfLongestSubstring(String s) {
//         if (s == null || s.length() == 0) return 0;
//         int res = 0;
//         int start = 0;
//         int end = 0;
//         int n = s.length();
//         Set<Character> set = new HashSet<>();
//
//         while (start < n && end < n){
//             System.out.println("start:" + start + s.charAt(start) + ", end:" + end + s.charAt(end));
//             System.out.println(set);
//             if (!set.contains(s.charAt(end))){
//                 set.add(s.charAt(end));
//                 res = Math.max(res, end - start + 1);
//                 end++;
//
//                 System.out.println("start:" + start + ", end:" + end);
//                 System.out.println(set);
//                 System.out.println("-----");
//             } else {
//                 set.remove(s.charAt(start));
//                 start++;
//                 System.out.println("start:" + start + ", end:" + end);
//                 System.out.println(set);
//                 System.out.println("=====");
//             }
//         }
//         return res;
//     }


//    //Approach 3: Sliding Window Optimized
//    public static int lengthOfLongestSubstring(String s) {
//        if(s == null || s.length() == 0) return 0;
//        int n = s.length(), res = 0;
//        Map<Character, Integer> map = new HashMap<>();
//
//        for (int start = 0, end = 0; end < n; end++){ //i is start position, j is end position
//            System.out.println("start:" + start + s.charAt(start) + ", end:" + end + s.charAt(end));
//            System.out.println("res" + res);
//            System.out.println(map);
//            if (map.containsKey(s.charAt(end))){
//                start = Math.max(map.get(s.charAt(end)), start); // reset start pointer //why this way?
//            }
//            map.put(s.charAt(end), end + 1); //end+1 //why?
//            System.out.println(map);
//            res = Math.max(end - start + 1, res);
//            System.out.println("start:" + start + s.charAt(start) + ", end:" + end + s.charAt(end));
//            System.out.println("res" + res);
//            System.out.println("-----");
//        }
//        return res;
//    }

    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("aaa"));
//        System.out.println(lengthOfLongestSubstring("abba"));
//        System.out.println(lengthOfLongestSubstring("abbcdefff"));
    }
}

//----------------------------------------------------------------------------------------------------------------

//// 1 bruce force, time exceed dunno right or wrong
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         if (s == null || s.length() == 0) return 0;

//         //bruce force
//         int n = s.length();
//         int res = 0;
//         for (int i = 0; i < n; i++){ //i is for locating the start of substring
//             for (int j = i + 1; j <= n; j++){ // j is for locating the end of substring // note that j <= n , not j < n) -> coz the real moment we r using j is in the util function. that time we sin use i < end(ie j). j here shd be just like s.length(), which means the real position + 1 (coz .length() start from 0)
//                 if (allUnique(s, i, j)) {
//                     res = Math.max(res, j - i);
//                 }
//             }
//         }
//         return res;
//     }

//     private boolean allUnique(String s, int start, int end){ // check if substring is a valid one
//         Set<Character> set = new HashSet<>();
//         for (int i = start; i < end; i++){
//             Character c = s.charAt(i);
//             if (set.contains(c)){
//                 return false;
//             }
//             set.add(c);
//         }
//         return true;
//     }
// }


// // Approach 2: Sliding Window - tO(n) (tO(2n) coz two pointers both loop thru the whole array in worse case)
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         if (s == null || s.length() == 0) return 0;
//         int res = 0;
//         int start = 0;
//         int end = 0;
//         int n = s.length();
//         Set<Character> set = new HashSet<>();

//         while (start < n && end < n){
//             if (!set.contains(s.charAt(end))){
//                 res = Math.max(res, end - start + 1);
//                 set.add(s.charAt(end));
//                 end++;
//             } else {
//                 set.remove(s.charAt(start));
//                 start++;
//             }
//         }
//         return res;

//     }
// }




// // Approach 2:  ting try rubbish (passed by myself writing :D)
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         if (s == null || s.length() == 0) return 0;
//         int res = 0, i = 0, j = 0;
//         int n = s.length();
//         Set<Character> set = new HashSet<>();

//         while (i < n && j < n) {
//             if (!set.contains(s.charAt(j))) {
//                 set.add(s.charAt(j++));
//                 res = Math.max(res, j-i);
//             } else {
//                 set.remove(s.charAt(i++));
//             }
//         }
//         return res;
//     }
// }

// //CSON (Approach 2: Sliding Window Optimized using HashSet cson) mo LC solution gum ho i think
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         if (s == null || s.length() == 0) return 0;
//         Set<Character> set = new HashSet<>();
//         int res = 0;

//         for (int i = 0, j = 0; j < s.length(); j++){
//             if (set.contains(s.charAt(j))) {
//                 set.remove(s.charAt(i++));
//                 j--;
//             } else {
//                 set.add(s.charAt(j));
//                 res = Math.max(res, set.size());
//             }
//         }
//         return res;
//     };
// }



// //Approach 3: Sliding Window Optimized using HashMap
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         if(s == null || s.length() == 0) return 0;
//         int n = s.length(), res = 0;
//         Map<Character, Integer> map = new HashMap<>();
//         for (int i = 0, j = 0; j < n; j++){ //i is start position, j is end position
//             if (map.containsKey(s.charAt(j))){
//                 i = Math.max(map.get(s.charAt(j)), i); // check if needa change start position (ie reset start pointer) //Star-where the magic work!!!妙啊 (draw out for illustartion jao wui ming. the core is immediately shift the startpointer to +`1 position of the previous item (which item value is == current end's value)) (important example that makes max() needed is "abba") //ie 見過他但他在你之前(leftward)，就不用update；在你後面，才需要update
//             }
//             map.put(s.charAt(j), j + 1); //is end+1
//             res = Math.max(j - i + 1, res);
//         }
//         return res;
//     }
// }




//// 4 Java (Assuming ASCII 128) (If we know that the charset is rather small, we can replace the Map with an integer array as direct access table.) -> concept is exactly same as approach 3, just use a fixed legnth array to improve space complex.
//class Solution {
//    public int lengthOfLongestSubstring(String s) {
//        if (s == null || s.length() == 0) return 0;
//        int res = 0;
//        int[] index = new int[256]; // store the corresponding (+1)location of the items.
//
//        for (int start = 0, end = 0; end < s.length(); end++){
//            start = Math.max(index[s.charAt(end)], start);
//            res = Math.max(res, end - start + 1);
//            index[s.charAt(end)] = end + 1;
//        }
//        return res;
//    }
//}



