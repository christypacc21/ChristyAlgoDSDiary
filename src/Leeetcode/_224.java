package Leeetcode;

import java.util.Stack;
/*
stack structure here: when the current char is "(", then add a pair of sign res into the stack. if is ")", pop out a pair to help calculate the new res
* Note that sign is with er 1 or -1, representing either + or -.

 | sign |
 | res  |
 |      |
 | sign |
 | res  |
 |      |
 | sign |
 | res  |
 -------
*/

public class _224 {
    public static int lc(String s) { // t n s n
        Stack<Integer> stack = new Stack<>();
        int sign = 1; // 1 means +, -1 means -
        int res = 0;
        for (int i = 0; i < s.length(); i++){
            //loop thru the input string, do action to items that with related value, respectively
            // -> to grab the number as a whole
            if (Character.isDigit(s.charAt(i))){ // if is digit 0123456789:
                int num = s.charAt(i) - '0'; // or int num = Integer.parseInt(String.valueOf(s.charAt(i))); //important
                // if the next char is still a digit,also include next char, to claim the whole number:
                while ( i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))){  //important
                    num = num * 10 + s.charAt(i + 1) - '0'; //important
                    i++;
                }
                res += num * sign; // important
            } else if (s.charAt(i) == '+'){
                sign = 1;
            } else if (s.charAt(i) == '-'){
                sign = -1;
            } else if (s.charAt(i) == '('){
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (s.charAt(i) == ')'){
                res = res * stack.pop() + stack.pop(); // implies: res * last sign + last res
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(lc(s));
    }
}
