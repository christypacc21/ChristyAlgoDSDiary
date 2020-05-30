//package Leeetcode;
///**
// * Definition for an interval.
// * public class Interval {
// *     int start;
// *     int end;
// *     Interval() { start = 0; end = 0; }
// *     Interval(int s, int e) { start = s; end = e; }
// * }
// */
//public class scanmeetingrm253 {
//    public int lc253(Interval[] intervals){
//        // 1 eparate items's value into two arrays
//        int[] starts = new int[intervals.length];
//        int[] ends = new int[intervals.length];
//        for(int i=0; i < intervals.length; i++) {
//            starts[i] = intervals.start;
//            ends[i] = intervals.end;
//        }
//
//        // 2 sort the arrays
//        Array.sort(starts);
//        Array.sort(ends);
//
//        // 3 processing
//        int res = 0;
//        int end_index = 0;
//        for(int i=0; i<intervals.length;i++){
//            if(starts[i] > ends[end_index]){
//                end_index++;
//            }else {
//                res++;
//            }
//        }
//        return res;
//    }
//}
