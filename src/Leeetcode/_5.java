package Leeetcode;

public class _5 {
    // //m2 //tO(n^2) sO(1)
     static String res = "";
     public static String longestPalindrome(String s) {
         if(s == null || s.length() == 0) return s;
         for (int i = 0; i < s.length(); i++){
             helper(s, i, i);
             helper(s, i, i+1);
         }
         return res;
     }
     public static void helper(String s, int left, int right){
         while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
             left--;
             right++;
         }
         String cur = s.substring(left + 1, right);
         if (cur.length() > res.length()){
             res = cur;
         }
     }

    public static void main(String[] args) {
//        System.out.println(longestPalindrome("abcdcba"));
        System.out.println(longestPalindrome("abccba")); 

    }
}
