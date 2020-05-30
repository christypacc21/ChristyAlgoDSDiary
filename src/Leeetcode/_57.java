//package Leeetcode;
//
//import java.util.ArrayList;
//
//// https://leetcode.com/problems/insert-interval/
//// https://cspiration.com/course/video?id=1584  CSON gong duc gei ho, ng ming jao watch him
//
//public class _57 {
//    public int[][] insert(int[][] intervals, int[] newInterval) {
//        if(newInterval == null) return intervals;
//
//        List<Interval> res = new ArrayList<>();
//        int i = 0;
//
//        // 1 沒有越界 && 沒有交集
//        while (i < intervals.size() && intervals.get(i).end < newInterval.start){
//            res.add(intervals.get(i++));
//        } //（沒有越界 && 沒有交集） 的 intervals 都 add 完了
//
//        // 2 剩下的就是有交集的intervals - 融合
//        while (i< intervals.size() && intervals.get(i).start <= newInterval.end){
//            newInterval.start = Math.min(newInterval.start, intervals.get(i).start); //取最先出現的 start
//            newInterval.end = Math.max(newInterval.end, intervals.get(i).end); //取最後出現的 end
//            i++;
//        }
//        res.add(newInterval); //把已經融合處理好的newInterval add 進 res
//
//        // 3 後面的 沒交集的也 add 埋進去
//        while (i < intervals.size()){
//            res.add(intervals.get(i));
//            i++;
//        }
//
//        return res;
//    }
//}
