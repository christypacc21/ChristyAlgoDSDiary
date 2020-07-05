package graph;

import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class DFS {
    //================================================================ M1(GraphNode class) Recursion
    public static void dfs(List<GraphNode> list){ // in a case that the input is a big graph, while has a lot of 子圖(ie separated graphs))
        HashSet<GraphNode> visited = new HashSet<>(); // why need this sentence?
        for (GraphNode node : list){ //in case has a lot of 子圖, has to also set a forloop to handle each graph one by one
            if (!visited.contains(node)){
                helper(node, visited);
            }
        }
    }
    public static void dfs2(GraphNode node){ // (normally interview case coz simpler)in a simpler case that the input is a single graph (not separated sub-graphs))
        helper(node, new HashSet<>());
    }
    public static void helper(GraphNode node, HashSet<GraphNode> visited){
        visited.add(node);
        System.out.println(node.label);
        for(GraphNode neighbor: node.neighbors){
            if (!visited.contains(neighbor)){
                helper(neighbor, visited);
            }
        }
    }
    //================================================================ M2(matrix) Recursion
    public static void dfsMatrix(int[][] matrix){
        int[] visited = new int[matrix.length];
        for (int i = 0; i < visited.length; i++){
            if(visited[i] == 0){
                helper2(matrix, visited, i);
            }
        }
    }

    public static void helper2(int[][] matrix, int[] visited, int vertex){
        visited[vertex] = 1;
        System.out.println(vertex);
        for(int i = 0; i < matrix.length; i++){
            if(matrix[vertex][i] == 1){
                if(visited[i] == 0){
                    helper2(matrix, visited, i);
                }
            }
        }
    }

    public static void main(String[] args){
        GraphNode a  = new GraphNode(0);
        GraphNode b  = new GraphNode(1);
        GraphNode c  = new GraphNode(2);
        GraphNode d  = new GraphNode(3);
        GraphNode e  = new GraphNode(4);
        GraphNode f  = new GraphNode(5);

        a.neighbors.add(b);
        a.neighbors.add(d);
        a.neighbors.add(f);

        b.neighbors.add(a);
        b.neighbors.add(e);
        b.neighbors.add(c);

        c.neighbors.add(b);
        c.neighbors.add(e);

        d.neighbors.add(a);
        d.neighbors.add(e);

        e.neighbors.add(d);
        e.neighbors.add(b);
        e.neighbors.add(c);

        f.neighbors.add(a);

        dfs2(a); //014325

        int[][] matrix = new int[][]{
                {0,1,0,1,0,1},
                {1,0,1,0,1,0},
                {0,1,0,0,1,0},
                {1,0,0,0,1,0},
                {0,1,1,1,0,0},
                {1,0,0,0,0,0},
        };
        dfsMatrix(matrix); //012435

    }
}
