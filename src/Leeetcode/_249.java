package Leeetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _249 { //
    public static List<List<String>> groupStrings(String[] strings){
        HashMap<String, List<String>> map = new HashMap<>(); // {"1,1,1," : ["abc", "bcd", "xyz"], ...}
        for (String s : strings){
            String key = getKey(s);
            List<String> list = map.getOrDefault(key, new ArrayList<>()); //{ xxx: []<-list }
            list.add(s);
            map.put(key, list); //{ xxx: [......] }
        }
        return new ArrayList<>(map.values()); //interesting n powerful syntax
    }

    private static String getKey(String s){
        char[] chars = s.toCharArray();
        String key = "";
        for (int i = 1; i < chars.length; i++){
            int diff = chars[i] - chars[i-1];
            key += diff < 0 ? diff + 26 : diff;
            key += ",";
            System.out.println(key);
        }
        return key;
    }

    public static void main(String[] args) {
        String[] strings = {"f", "abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"}; //keys eg : "f" is "", "abc" is "1,1," ...
        System.out.println(groupStrings(strings));
    }


}
