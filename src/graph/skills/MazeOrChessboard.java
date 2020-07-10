package graph.skills;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//FFBFS (Ming jor :) 2020-7-10)
//followup
//        -1 能否有通路（Code）
//        -2 走日字/斜上
//        -3 最短距離（Code）
//        -4 只能先走到頭，不能在中間轉其他方向: LC490, 505, 499

//public class MazeOrChessboard {  // followup 1能否有通路
//    private boolean hasPath(int[][] maze, int[] start, int[] end) {
//        int[][] directions = new int[][]{{1,0}, {-1,0},{0,1},{0,-1}}; //direction：右左下上
//
//        boolean[][] visited = new boolean[maze.length][maze[0].length]; // coz dun wanna change input
//
//        Queue<Point> queue = new LinkedList<>();
//        queue.offer(new Point(start[0], start[1])); // the start's coordinate
//        visited[start[0]][start[1]] = true;
//
//        while (!queue.isEmpty()){
//            Point cur = queue.poll();
//            if (cur.x == end[0] && cur.y == end[1]){ // if item reached, means hv path, return true then
//                return true;
//            }
//            for (int[] direction : directions) {
//                int newX = cur.x + direction[0];
//                int newY = cur.y + direction[1];
//                if (isValid(maze, newX, newY) && !visited[newX][newY]) { // if is valid and not yet visited,
//                    queue.offer(new Point(newX, newY)); //add to queue.
//                    visited[newX][newY] = true; // set visited to true
//                }
//            }
//        }
//
//        //print out see see
//        for (boolean[] visit : visited){
//            System.out.println(Arrays.toString(visit));
//        }
//
//        return false; // if at the end still cant find, means no path, return false
//    }
//
//    private boolean isValid(int[][] maze, int x, int y){
//        return x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 1; // xy in boundary (>=0 and dun exceed maze length) , and that coordinate has path (ie == 1)
//    }
//
//    class Point{
//        int x;
//        int y;
//
//        public Point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//
//    public static void main(String[] args) {
//        int[][] maze = new int[][]{
//                {1,0,0,0,0},
//                {1,0,0,0,0},
//                {1,0,0,0,0},
//                {1,0,0,0,0},
//                {1,1,1,0,1},
//        };
//        MazeOrChessboard mazeOrChessboard = new MazeOrChessboard();
//        System.out.println(mazeOrChessboard.hasPath(maze, new int[]{0,0}, new int[]{4,4}));
//    }
//}
//
//


public class MazeOrChessboard {  // followup 3 最短距離
    private int hasPath(int[][] maze, int[] start, int[] end) { // followup 3 最短距離
        int[][] directions = new int[][]{{1,0}, {-1,0},{0,1},{0,-1}}; //direction：右左下上

        boolean[][] visited = new boolean[maze.length][maze[0].length]; // coz dun wanna change input

        int res = 0;

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(start[0], start[1])); // the start's coordinate
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()){
            res ++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point cur = queue.poll();
                if (cur.x == end[0] && cur.y == end[1]){ // if item reached, means hv path, return true then
                    //print out see see
                    for (boolean[] visit : visited){
                        System.out.println(Arrays.toString(visit));
                    }
                    return res - 1;
                }
                for (int[] direction : directions) {
                    int newX = cur.x + direction[0];
                    int newY = cur.y + direction[1];
                    if (isValid(maze, newX, newY) && !visited[newX][newY]) { // if is valid and not yet visited,
                        queue.offer(new Point(newX, newY)); //add to queue.
                        visited[newX][newY] = true; // set visited to true
                    }
                }
            }
        }

        return -1; // if at the end still cant find, means no path, return false
    }

    private boolean isValid(int[][] maze, int x, int y){
        return x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 1; // xy in boundary (>=0 and dun exceed maze length) , and that coordinate has path (ie == 1)
    }

    class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] maze = new int[][]{
                {1,0,0,0,0},
                {1,0,0,0,0},
                {1,0,0,0,0},
                {1,0,0,0,0},
                {1,1,1,1,1},
        };
        MazeOrChessboard mazeOrChessboard = new MazeOrChessboard();
        System.out.println(mazeOrChessboard.hasPath(maze, new int[]{0,0}, new int[]{4,4}));
    }
}
