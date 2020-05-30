package Leeetcode;

import java.util.ArrayList;
import java.util.List;

//Best Meeting Point https://blog.csdn.net/xudli/article/details/49420623
//        Total Accepted: 701 Total Submissions: 1714 Difficulty: Medium
//        A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated usingManhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
//
//        For example, given three people living at (0,0), (0,4), and(2,2):
//
//        1 - 0 - 0 - 0 - 1
//        |   |   |   |   |
//        0 - 0 - 0 - 0 - 0
//        |   |   |   |   |
//        0 - 0 - 1 - 0 - 0
//    (the input is a 2D array including 0 and 1, like the above graph illustration.
//        The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.

//[思路]二维的等于一维的相加, 一维的最小点必在median点(用反证法可以证明).

public class _296 {
    public static int lc(int[][] grid){ //time O(m * n) space O(n)
        int m = grid.length; // big array eg 3
        int n = grid[0].length; // small array eg 5

        List<Integer> I = new ArrayList<>(); // x coordinate array (contains x coordinates of homes)
        List<Integer> J = new ArrayList<>(); // y coordinate array (contains y coordinates of homes)

        for (int i = 0; i < m; i++){  // construct x coordinate array
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1){ // a home located
                    I.add(i);
                }
            }
        }

        for (int j = 0; j < n; j++){ // construct y coordinate array
            for (int i = 0; i < m; i++){
                if (grid[i][j] == 1){ // a home located
                    J.add(j);
                }
            }
        }
        return min(I) + min(J);
    }
    public static int min(List<Integer> list){ //important ???
        int i = 0, j = list.size();
        int sum = 0;
        while (i < j){
            sum += list.get(j--) - list.get(i++);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,0,0,0,1},{0,0,0,0,0},{0,0,1,0,0}};
//        int[][] nums = {{0,1,1,},{1,1,1}};
        System.out.println(lc(nums));
    }
}




//         find the meeting point
//         x coordinate, add the distance one by one
//         y coordinate, add the distance one by one
