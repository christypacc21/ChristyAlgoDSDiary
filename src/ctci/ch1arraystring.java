package ctci;

public class ch1arraystring {
    public static Boolean oneisunique(String str){
        if(str.length()>128) return false;

        boolean[] char_set = new boolean[128];
        for(int i = 0; i < str.length(); i++){
            int val = str.charAt(i);
            if(char_set[val]){
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    public static boolean twoispermutation(String a, String b) {
        if(a.length() != b.length()) return false;

        int[] statistics = new int[128]; // Assumed character set uses Ascii //compare with cson, in case only small capital and only english alphabet, i think here can shrink to size 26 by using ...charAt(i) - 'a';

        char[] a_array = a.toCharArray();
        for(char c : a_array) {
            statistics[c]++;
        }

        for (int i = 0; i < b.length(); i++) {
            int c = (int) b.charAt(i);
            statistics[c]--;
            if (statistics[c] < 0) {
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        System.out.println(oneisunique("asdfqewr"));
        System.out.println(twoispermutation("abcdeef", "feedcba"));
    }

}
