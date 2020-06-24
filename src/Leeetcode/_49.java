package Leeetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs){ //["eat", "tea", "tan", "ate", "nat", "bat"] | str = "eat"

            int[] count = new int[26];
            for (Character ch : str.toCharArray()){ //['e', 'a', 't'] | ch = 'e'
                count[ch - 'a']++;
            }

            String s = "";
            for (int i = 0; i < count.length; i++){
                if (count[i] != 0) {
                    s += String.valueOf(count[i]) + String.valueOf((char)(i + 'a'));
                }
            } //s="1a1e1t"

            if (map.containsKey(s)){ //map.containsKey("1a1e1t")
                List<String> list = map.get(s);
                list.add(str);
            } else {
                List<String> list = new ArrayList<>(); // make a list to hold "eat"
                list.add(str);
                map.put(s, list); //"1a1e1t": ["eat"]
            }
        }
//        System.out.println(map.values());
        return new ArrayList<>(map.values()); // hashmap.values() -> get all values of the hashmap ?why here have to wrap in new ArrayList<>()?
    }

    public static void main(String[] args) {
        String[] s = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(s));
    }
}
