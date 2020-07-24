package Leeetcode;

public class _205 {
    public static boolean isIsomorphic(String s, String t) { //countingSort(tO(n), sO(1)) (a bit hard to understand)
        int[] sChars = new int[256];
        int[] tChars = new int[256];

        for (int i = 0; i < s.length(); i++){
            System.out.println(sChars[s.charAt(i)]);
            System.out.println(tChars[t.charAt(i)]);
            if (sChars[s.charAt(i)] != tChars[t.charAt(i)]){
                return false;
            } else {
                System.out.println(t.charAt(i)); //t
                System.out.println(tChars['a']); //0
                System.out.println(tChars['a'] = 'a'); //97
                System.out.println('a' - 0); //97
                // so it means 'a' = 97 ? Yes coz line 5 and 6 use int[] to initialize the array!!!!
                 sChars[s.charAt(i)] = tChars[t.charAt(i)] = t.charAt(i); //where the miracle happens...
//                sChars[s.charAt(i)] = t.charAt(i); //sChar['p'] = 't';
//                tChars[t.charAt(i)] = t.charAt(i); //tChar['t'] = 't';
                System.out.println(sChars[s.charAt(i)]);
                System.out.println(tChars[t.charAt(i)]);
            }
            System.out.println("-------");
        }
        return true;

//        int[] map1 = new int[256];
//         int[] map2 = new int[256];
//
//         if (s.length() != t.length()) return false;
//
//         for (int i = 0; i < s.length(); i++) {
//             char ss = s.charAt(i);
//             char tt = t.charAt(i);
//             if (map1[ss] == 0) {
//                 map1[ss] = tt;
//             } else {
//                 if (map1[ss] != tt) return false;
//             }
//             if (map2[tt] == 0) {
//                 map2[tt] = ss;
//             } else {
//                 if (map2[tt] != ss) return false;
//             }
//         }
//         return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("pajer", "title"));
    }

}
