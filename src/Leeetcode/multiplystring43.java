package Leeetcode;

public class multiplystring43 {
    public static String multiplystring(String num1, String num2) {
        if (num1 == null || num2 == null) return "0";
        int[] digits = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() -1; j >= 0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1; // the position of digits[]
                int sum = product + digits[p2];
                digits[p1] += sum / 10;
                digits[p2] = sum % 10;
            }
        }
        StringBuilder res = new StringBuilder(); // In java, String is immutable, so if wanna do sth like append, hv to use StringBuilder
        for (int digit : digits) {
            if (!(digit == 0 && res.length() == 0)) { //if not (is the first one and the value of digit = 0)
                res.append(digit);
            }
        }
        return res.length() == 0 ? "0" : res.toString();
    }

    // time O(n * m)
    // space O(n + m)

    public static void main(String[] args) {
        System.out.println(multiplystring("123","45")); // "5535"
    }

}



