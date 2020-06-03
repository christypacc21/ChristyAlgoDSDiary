package Leeetcode;

import java.util.ArrayList;
import java.util.List;

public class _118 {
    public static List<List<Integer>> generate(int numRows) { // time space O(n^2)
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++){
            list.add(0, 1); // add an item 1 to list[0]
            System.out.println("======");
            System.out.println(list);
            for(int j = 1; j < list.size() - 1; j++){
                list.set(j, list.get(j) + list.get(j + 1)); //list.set(j, sum)
            }
            System.out.println(list);
            res.add(new ArrayList<>(list));
        }
        return res;
    }

    public static void main(String[] args) {
        int num = 5;
        System.out.println(generate(5));
    }
}
