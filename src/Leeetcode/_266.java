package Leeetcode;

import java.util.HashSet;

public class _266 {
    public static boolean _266(String s){ //t n s n
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()){
            if (set.contains(c)){
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.size() <=1;
    }

    public static boolean _266_2(String s){ //t n , s 1 (coz array is fixed size)
        char[] count = new char[256];
        int res = 0;
        for (char c : s.toCharArray()){
            if(count[c] > 0){
                count[c]--;
            } else {
                count[c]++;
            }
        }
        for (int i = 0; i < count.length; i++){
            if(count[i] != 0) res++;
        }
        return res <= 1;
    }
}
