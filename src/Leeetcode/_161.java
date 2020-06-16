package Leeetcode;
//https://blog.csdn.net/zhangpeterx/article/details/90577678

public class _161 {
    public static boolean lc(String s, String t){
        int lenS = s.length();
        int lenT = t.length();

        if(Math.abs(lenS - lenT) > 1){
            return false;
        }

        for (int i = 0; i < Math.min(lenS, lenT); i++){
            if (s.charAt(i) != t.charAt(i)){
                if (lenS == lenT){
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else if (lenS > lenT){
                    return s.substring(i + 1).equals(t.substring(i));
                } else if (lenT > lenS){ // or just else
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }
        return Math.abs(lenS = lenT) == 1;
    }

    public static void main(String[] args) {
//        String s = "abcre";
//        String t = "abere";
//        String s = "abdc";
//        String t = "abc";
        String s = "abc";
        String t = "abdc";
        System.out.println(lc(s, t));
    }
}
