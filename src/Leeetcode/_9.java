package Leeetcode;

public class _9 {
    public static boolean isPalindrome(int x) {
        if (x < 0 || x != 0 && x % 10 == 0) return false; // tO(logn) s O(1) //handle corner case that cant use % 10 to handle here eg 1000
        int palind = x;
        int rev = 0;
        while (x > 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return palind == rev;
    }

    public static void main(String[] args) {
//        System.out.println(isPalindrome(1234321));
        System.out.println(isPalindrome(1000));
    }
}
