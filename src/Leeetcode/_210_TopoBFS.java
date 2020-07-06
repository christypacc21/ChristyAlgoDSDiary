package Leeetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _210_TopoBFS { //(watch 6-4 cson 基礎 animation)
 public int[] findres(int numCourses, int[][] prerequisites){
     int[] res = new int[numCourses];
     int k = 0;

     // 1 計算入度
     int[] indegree = new int[numCourses];
     for (int[] pair : prerequisites){
        indegree[pair[0]]++;
     }

     Queue<Integer> queue = new LinkedList<>();
     for (int i = 0; i < indegree.length; i++){
         if (indegree[i] == 0){
             queue.offer(i);
             res[k++] = i;
         }
     }

     while (!queue.isEmpty()){
         int pre = queue.poll();
         for (int[] pair : prerequisites){
             if (pair[1] == pre){
                 indegree[pair[0]]--;
                 if (indegree[pair[0]] == 0){
                     queue.offer(pair[0]);
                     res[k++] = pair[0];
                 }
             }
         }
     }
     return (k == numCourses) ? res : new int[0]; //check if has 環
 };

}
