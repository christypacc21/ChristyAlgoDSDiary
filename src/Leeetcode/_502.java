package Leeetcode;

import java.util.PriorityQueue;

public class _502 {

    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        //[[capital, profit],[capital, profit]...]
        PriorityQueue<int[]> cap = new PriorityQueue<>((a, b) -> (a[0] - b[0])); //按 capital 排序 (小到大)
        PriorityQueue<int[]> pro = new PriorityQueue<>((a,b) -> (b[1] - a[1])); //按 Profit 排序 (大到小)

        for (int i = 0; i < Profits.length; i++){
            cap.add(new int[]{Capital[i], Profits[i]});
        }

        for (int i = 0; i < k; i++){
            while(!cap.isEmpty() && cap.peek()[0] <= W){
                pro.add(cap.poll());
            }
            if (pro.isEmpty()){
                break;
            }
            W += pro.poll()[1];
        }
        return W;
    }

    public static void main(String[] args) {
        System.out.println(findMaximizedCapital(2,0, new int[]{1,2,3}, new int[]{0,1,1}));
//        System.out.println(findMaximizedCapital(2,0, new int[]{1,0,0,10}, new int[]{0,1,1}));
    }
}
