package Leeetcode;
// https://leetcode.com/problems/game-of-life/
//According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
//        Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
//
//        1 Any live cell with fewer than two live neighbors dies, as if caused by under-population. (1->0)
//        2 Any live cell with two or three live neighbors lives on to the next generation. (remains 1)
//        3 Any live cell with more than three live neighbors dies, as if by over-population. (1->0)
//        4 Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction. (0->1)

//        Write a function to compute the next state (after one update) of the board given its current state.
//        The next state is created by applying the above rules simultaneously to every cell in the current state,
//        where births and deaths occur simultaneously.
//        (which mean each cell's change is based on the input, not any updated date)
//
//        Example:
//        Input:
//        [ [0,1,0],
//          [0,0,1],
//          [1,1,1],
//          [0,0,0]  ]
//        Output:
//        [  [0,0,0],
//           [1,0,1],
//           [0,1,1],
//           [0,1,0]  ]

import java.util.Arrays;

public class _289 { // cson gong duc gei ho
    // this question's importance ： the 位運算表示狀態的思想
    // (in this question, board[i][j] += 2 means turn bit(00 or 01) to bit(10 or 11)
    // -> then at the end when we do >> 1, it will retrieve the leftmost digit bit(01 or 01), 1 means live, 0 means dead.
    // Since question requires us to do it in place, so we use this 位運算表示狀態的思想 to handle this question
    // timeO(m * n)  spaceO(1)
    public static int[][] lc(int[][] board){
        if(board == null || board.length == 0) return board;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int count = countNeighbour(board, i, j);
                if (board[i][j] == 1){ // if the current is a live cell
                    if (count == 2 || count == 3){  // (rule2 -> status remain 1)
                        board[i][j] += 2; //use the concept of 位運算 to turn it into a live cell ?
                    }
                } else if (count == 3){ // (rule 4 -> status change from 0 to 1) if the current cell is a dead cell and count == 3
                    board[i][j] += 2; //use the concept of 位運算 to turn it into a live cell ?
                }
            }
        }
        for (int i = 0; i < m; i++){ //整體進行一個移位的操作
            for (int j = 0; j < n; j++){
                board[i][j] = board[i][j] >> 1; // 將 the cell 變成 下一個狀態
            }
        }
        return board;
    }
    private static int countNeighbour(int[][] board, int i, int j){
        int count = 0;
        for (int row = Math.max(0, i- 1); row <= Math.min(i + 1, board.length - 1); row++){ // Math 用來防止越界 (only needa deal with cell's 上下左右 and 4角 的 neighbourCells
            for (int col = Math.max(0, j - 1); col <= Math.min(j + 1, board[0].length - 1); col++){ // Math 用來防止越界 (only needa deal with cell's 上下左右 and 4角 的 neighbourCells
                if (row == i && col == j) continue; // if is itself, then dun need to handle
                if ((board[row][col] & 1) == 1) count++; // if any related neighbour cell is 1, then count++
            }
        }
        return count;
    }


    public static void print(int[][] matrix){
        for(int i=0 ; i < matrix.length; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {  {0,1,0},
                            {0,0,1},
                            {1,1,1},
                            {0,0,0} };
        print(lc(matrix));
    }
}
