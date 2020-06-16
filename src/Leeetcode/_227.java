package Leeetcode;

import java.util.Stack;

public class _227 {
    public static int calculate(String s) { // t n s n
        if (s == null || s.length() == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        int res = 0;
        char sign = '+';

        int num = 0;
        for(int i = 0; i < s.length(); i++){

            if (Character.isDigit(s.charAt(i))){
                num = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))){ // Note that i starts from 0, so will not overflow dun worry
                    num = num * 10 + s.charAt(i+1) - '0';
                    i++;
                }
            }
//"3*2+4-5/2"

            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1){ // if is +-*/ || last item in the string
                if (sign == '+') stack.push(num);
                if (sign == '-') stack.push(-num);
                if (sign == '*') stack.push(stack.pop() * num);
                if (sign == '/') stack.push(stack.pop() / num);

                sign = s.charAt(i);
                num = 0;
            }
        }

        for (int i : stack){
            res += i;
        }
        return res;
    }

    public static int calculate2(String s) { // t n s 1 // i feel like this method so many edge case to handle... and didnt be more efficient than M1
        if (s == null || s.length() == 0) return 0;
        s = s.trim().replaceAll(" +", ""); //O(n)
        int res = 0;
        int preVal = 0;
        int i = 0;
        char sign = '+';
        while (i < s.length()){
            int curVal = 0;
            while (i < s.length() && Character.isDigit(s.charAt(i))){
                curVal = curVal * 10 + s.charAt(i) - '0';
                i++;
            }
            //actually still using last sign here:
            if (sign == '+'){
                res += preVal;
                preVal = curVal;
            } else if (sign == '-'){
                res += preVal;
                preVal = -curVal;
            } else if (sign == '*'){
                preVal = preVal * curVal;
            } else if (sign == '/'){
                preVal = preVal / curVal;
            }
            //update sign
            if (i < s.length()){
                sign = s.charAt(i);
                i++;
            }
        }
        res += preVal;
        return res;
    }

    public static void main(String[] args) {
//        String s = "123";
//        String s = "3+12/2*6+34+2*6/4";
//        String s = "3+2*2";
        String s = "3*2+4-5/2";
        System.out.println(calculate(s));
        String s2 = "3*2+4-5/2";
        System.out.println(calculate2(s2));
    }
}
