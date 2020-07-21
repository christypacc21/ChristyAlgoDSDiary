package graph.prim;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    //鄰接表方式
    int vertices;
    List<Edge>[] list;

    public Graph(int vertices){
        this.vertices = vertices;
        list = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++){
            list[i] = new ArrayList<>();
        }
    }

    public void addEdge(int start, int end, int weight){ //non directional graph actually implies mutual directional graph, so two edge points to each other.
        Edge edge = new Edge(start, end, weight);
        list[start].add(edge);

        edge = new Edge(end, start, weight);
        list[end].add(edge);
    }

}
