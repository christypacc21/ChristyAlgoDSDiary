package Leeetcode;

import java.util.Arrays;
import java.util.Stack;

public class _388 {
    // \n -> next line , \t -> next level
    public static int lc(String input) { //t n s n
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int res = 0;
//        String[] haha = input.split("\n");
//        System.out.println(Arrays.toString(haha));

        for (String s : input.split("\n")){
//            System.out.println(s.lastIndexOf("\t")); // -1, coz purely "\t" here seems will be auto progressed by Java (regex those things?)
            int level = s.lastIndexOf("\t") + 1;
            while (level + 1 < stack.size()){
                stack.pop();
            }
            int len = stack.peek() + s.length() - level + 1;
            stack.push(len);
            if (s.contains(".")){
                res = Math.max(res, len - 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        System.out.println(lc(s));
    }
}
