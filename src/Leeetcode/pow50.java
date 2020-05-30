package Leeetcode;
// https://leetcode.com/problems/powx-n/
// Implement pow(x, n), which calculates x raised to the power n (xn).

//  -100.0 < x < 100.0
//   n is a 32-bit signed integer, within the range [−231, 231 − 1]

/**
 *                                                      5^7
 *                                  5^3      *          5^3                             *       5
 *                                   y       *           y                              *       x
 *                           (5^1 * 5^1 * 5) *     (5^1 * 5^1 * 5)                      *       5
 *                           ( y  *  y  * x) *     ( y  *  y  * x)                      *       x
 *  {(5^0 * 5^0 * 5) * (5^0 * 5^0 * 5) * 5}  * {(5^0 * 5^0 * 5) * (5^0 * 5^0 * 5) * 5}  *       5
 *               {(y*y*x) * (y*y*x) * x}     * {(y*y*x) * (y*y*x) * x}                  *       x
 *
 *
 *
 *                y           *               y            *   x
 *     (y    *    y    *  x ) *    (y    *    y    *  x )  *   x
 *  ((y*y*x) * (y*y*x) *  x ) * ((y*y*x) * (y*y*x) *  x )  *   x
 *
 *
 *
 * 5^7 = 5^3 * 5^3 * 5 (y*y*x)
 * 5^3 = 5^1 * 5^1 * 5 (y*y*x)
 * 5^1 = 5^0 * 5^0 * 5 (y*y*x)
 * 5^0 = 1
 */



public class pow50 {
    //time O(logn)
    //space O(logn)
    public static double myPow(double x, int n) { //eg x = 5, n = 7   (5^7)
        if (n > 0) {
            return pow(x, n);
        } else {
            return 1.0 / pow(x, n);
        }
    }
    public static double pow (double x, int n) {
        if (n == 0) { // n^0 = 1
            return 1;
        }
        double y = pow(x, n / 2);
        if (n % 2 == 0) { //mainpoint
            return y * y;
        } else {
            return y * y * x;
        }
    }


    //time O(logn)
    // space O(1)
    public static double myPow2(double x, int n) {
        if (n == 0) return 1;

        double res = 1;
        // int : -6.. ~ +6..  -2^32 ~ 2 ^ 32 -1 Integer.MIN_VALUE
        long abs = Math.abs((long)n);
        while (abs > 0) {
            if (abs % 2 != 0) { //mainpoint
                res *= x;
            }
            x *= x;
            abs /= 2;
        }
        if (n < 0) {
            return 1.0 / res;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(myPow(2.00000, 10)); //1024.00000
        System.out.println(myPow(2.10000, 3)); //9.26100
        System.out.println(myPow(2.00000, -2)); //0.25000 //Explanation: 2**-2 = 1/(2**2) = 1/4 = 0.25

        System.out.println(myPow2(2.00000, 10)); //1024.00000
        System.out.println(myPow2(2.10000, 3)); //9.26100
        System.out.println(myPow2(2.00000, -2)); //0.25000 //Explanation: 2**-2 = 1/(2**2) = 1/4 = 0.25
    }
}
