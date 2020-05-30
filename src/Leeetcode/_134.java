package Leeetcode;
//134. Gas Station

//cson video gong duc ok, ng ming can rewatch

public class _134 {
    public static int ls(int[] gas, int[] cost){
        if (gas.length == 0 || cost.length==0 || gas.length != cost.length) return -1;

        int total = 0, sum = 0, start = 0;
        for (int i = 0; i < gas.length; i++){
            total += (gas[i] - cost[i]); // 看他能否走完全程 （數學定理）
            if (sum < 0){   //important
                sum = (gas[i] - cost[i]);
                start = i;   //important
            } else {
                sum += (gas[i] - cost[i]);
            }
        }
        return total < 0 ? -1 : start; // return either -1(根本就不能走完全程) or start's value.
    }

    public static void main(String[] args) {
        int[] gas = {2,3,4,5,6,7,8};
        int[] cost = {1,7,3,4,5,6,2};
        System.out.println(ls(gas, cost));
    }
}
