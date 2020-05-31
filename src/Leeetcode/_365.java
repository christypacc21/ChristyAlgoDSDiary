package Leeetcode;
//Water and Jug Problem 最大公因數 (math problem)
public class _365 {
    public static boolean lc(int x, int y, int z){
        if (x + y < z) return false;
        if (x == z || y == z || x + y == z) return true;
        return z % gcd(x,y) == 0;
    }

    private static int gcd(int a, int b){
        if (b==0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(lc(3,5,4));
        System.out.println(lc(2,6,5));
    }
}
