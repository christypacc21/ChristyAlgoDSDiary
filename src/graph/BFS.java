package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void bfs(GraphNode graphNode){
        HashSet<GraphNode> visited = new HashSet<>();
        Queue<GraphNode> queue = new LinkedList<>();

        visited.add(graphNode);
        queue.offer(graphNode);

        while(!queue.isEmpty()){
            GraphNode node = queue.poll();
            System.out.println(node.label);
            for (GraphNode neighbor : node.neighbors){
                if (!visited.contains(neighbor)){
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
            System.out.println();
        }
    }

    public static void bfs2(GraphNode graphNode){
        HashSet<GraphNode> visited = new HashSet<>();
        Queue<GraphNode> queue = new LinkedList<>();

        visited.add(graphNode);
        queue.offer(graphNode);

        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                GraphNode node = queue.poll();
                System.out.println(node.label);
                for (GraphNode neighbor : node.neighbors){
                    if (!visited.contains(neighbor)){
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            System.out.println();
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

        bfs(a); //013542

//        bfs2(a); //013542

        int[][] matrix = new int[][]{
                {0,1,0,1,0,1},
                {1,0,1,0,1,0},
                {0,1,0,0,1,0},
                {1,0,0,0,1,0},
                {0,1,1,1,0,0},
                {1,0,0,0,0,0},
        };



//        dfsMatrixIteration(matrix); //0 5 3 4 2 1
    }
}
