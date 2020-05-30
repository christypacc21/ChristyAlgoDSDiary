package Leeetcode;
//https://leetcode.com/problems/sqrtx/

public class sqrt69 {
    //time O(logn)
    //space O(1)
    public static int mySqrt(int x) {
        if(x <= 0) return 0;

        int low = 1, high = x;
        while (low <= high) { // why <= not < ?
            long mid = (high - low) / 2 + low;    // vs long mid = (high + low) / 2 ? (->edward said week 2 wui gong woo)
            if (mid * mid == x) {
                return (int)mid;
            } else if (mid * mid < x) {
                low = (int)mid + 1;
            } else {
                high = (int)mid - 1;
            }
        }
        //mainpoint
        if (high * high < x) {
            return high;
        } else {
            return low;
        }
    }


    // time Dunno
    // space O(1)
    public static int mySqrt_newton(int x) {
        long res = x;
        while (res * res > x) {
            res = (res + x / res) / 2;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
        System.out.println(mySqrt_newton(8));
    }
}


