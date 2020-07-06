package Leeetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//upmud?
public class _210_TopoDFS {

    public int[] findOrder(int numCourses, int[][] prerequisites){
        /*預處理*/
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pair: prerequisites){
            int prev = pair[1];
            int next = pair[0];
            graph.get(prev).add(next);
        }

        /* DFS */
        /* 0: unvisited, 1: visiting, 2: visited */
        HashMap<Integer, Integer> visited = new HashMap<>();
        for (int i = 0; i < numCourses; i++){
            visited.put(i, 0);
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i <numCourses; i++){
            if (visited.get(i) == 0){
                if (!helper(graph, visited, res, i)){ //check if has 環
                    return new int[0];
                }
            }
        }

        int[] result = new int[numCourses];
        for (int i = 0; i < result.length; i++){
            result[i] = res.get(numCourses - i - 1);
        }
        return result;
    }

    public boolean helper (List<List<Integer>> graph, HashMap<Integer, Integer> visited, List<Integer> res, int i){
        if (visited.get(i) == 2){
            return true;
        }
        if (visited.get(i) == 1){
            return false;
        }
        visited.put(i, 1);
        for (int j : graph.get(i)){
            if(!helper(graph, visited, res, j)){
                return false;
            }
        }
        visited.put(i, 2);
        res.add(i);
        return true;
    }
}
