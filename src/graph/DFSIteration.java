package graph;

import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class DFSIteration {
    //================================================================ M1(GraphNode class) Iteration
    public static void dfsIteration(GraphNode graphNode){
        Stack<GraphNode> stack = new Stack<>();
        HashSet<GraphNode> visited = new HashSet<>();
        stack.push(graphNode);
        visited.add(graphNode);
        while(!stack.isEmpty()){
            GraphNode node = stack.pop();
            System.out.println(node.label);
            for (GraphNode neighbor: node.neighbors){
                if(!visited.contains(neighbor)){
                    stack.push(neighbor);
                    visited.add(node);
                }
            }
        }
    }

    //================================================================ M2(Matrix) Iteration
    public static void dfsMatrixIteration(int[][] matrix){
        int[] visited = new int[matrix.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < visited.length; i++){
            if (visited[i] == 0){
                visited[i] = 1;
                stack.push(i);
                while(!stack.isEmpty()){
                    Integer vertex = stack.pop();
                    System.out.println(vertex);
                    for (int j = 0; j < matrix.length; j++){
                        if (matrix[vertex][j] == 1){
                            if(visited[j] == 0){
                                stack.push(j);
                                visited[j] = 1;
                            }
                        }
                    }
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

        int[][] matrix = new int[][]{
                {0,1,0,1,0,1},
                {1,0,1,0,1,0},
                {0,1,0,0,1,0},
                {1,0,0,0,1,0},
                {0,1,1,1,0,0},
                {1,0,0,0,0,0},
        };

        dfsIteration(a); //05342111

        dfsMatrixIteration(matrix); //0 5 3 4 2 1
    }
}
