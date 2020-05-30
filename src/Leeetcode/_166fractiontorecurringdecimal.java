package Leeetcode;

//https://leetcode.com/problems/fraction-to-recurring-decimal/
import java.util.HashMap;

//time O(n)
//space O(n)

// better use debugger + hand to write out the long division, to inspect the flow and logic, much easier to understand

public class _166fractiontorecurringdecimal {
    public static String fractionToDecimal(int numerator, int denominator) {

        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        res.append((numerator > 0) ^ (denominator > 0) ? "-" : "");
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        res.append(num/den); //Java geh /, will auto math.floor(ignore any decimals)
        num %= den; // 除不盡，有小數點

        if(num == 0) { // 如果除得盡（是整數），直接return
            return res.toString();
        }

        res.append(".");
        HashMap<Long, Integer>map = new HashMap<>();
        map.put(num, res.length());

        while (num != 0) {
            num *= 10; // shift leftward by 1 digit
            res.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            } else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1,2));
        System.out.println(fractionToDecimal(2,1));
        System.out.println(fractionToDecimal(2,3));
    }
}
