//package Leeetcode;
//
////Given a collection of intervals, merge all overlapping intervals.
////
////        Example 1:
////
////        Input: [[1,3],[2,6],[8,10],[15,18]]
////        Output: [[1,6],[8,10],[15,18]]
////        Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
////        Example 2:
////
////        Input: [[1,4],[4,5]]
////        Output: [[1,5]]
////        Explanation: Intervals [1,4] and [4,5] are considered overlapping.
//
//import java.util.ArrayList;
//import java.util.Collections;
//
//public class _56 {
//    public int[][] merge(int[][] intervals){
//
//        // step 1, sort the intervals
//        Collections.sort(intervals, (a, b) -> a.start - b.start); //time O(nlogn)
//
//        int start = intervals.get(0).start;
//        int end = intervals.get(0).end;
//
//        //
//        List<Interval> res = new ArrayList<>();
//        for(Interval interval : intervals){
//            if(interval.start <= end){ // if overlaps with the previous interval
//                end = Math.max(end, interval.end);
//            } else { // if no overlap with the prev interval, then directly add the current interval into List.
//                res.add(new Interval(start, end));
//                start = interval.start;
//                end = interval.end;
//            }
//        }
//        res.add(new Interval(start, end)); // handle the last interval to be added
//        return res;
//    }
//}
