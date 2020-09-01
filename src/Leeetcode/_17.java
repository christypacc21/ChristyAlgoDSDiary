package Leeetcode;

import java.util.ArrayList;
import java.util.List;

public class _17 {
    private static String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pars", "tuv", "wxyz"};
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        helper (res, digits, "", 0);
        //(the array of string holding the result, input that wont change, states 1 that passing along BT (the potential answer to add to res), states 2 that passing along BT)
        return res;
    }

    public static void helper(List<String> res, String digits, String s, int index) {
        if (index == digits.length()) {
            res.add(s);
            return;
        }
        String letters = mapping[digits.charAt(index) - '0']; //eg mapping['2'-'0'] is "abc"
        for (int i = 0; i < letters.length(); i++) { //generate possibilities of this layer
            helper(res, digits, s + letters.charAt(i), index + 1); //index + 1 here means start focusing on the next item (next layer) ('3') ie digits[0+1]='3',
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
