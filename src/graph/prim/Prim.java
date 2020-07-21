package graph.prim;

public class Prim {
    public void primMST(Graph graph) {
 //8-4 contnet, too bulky and less chance to use, dun wanna watch ju
    }

    public static void main(String[] args){
        Graph graph = new Graph(6);
        graph.addEdge(0,1,6);
        graph.addEdge(0,2,1);
        graph.addEdge(0,3,5);
        graph.addEdge(1,2,5);
        graph.addEdge(1,4,3);
        graph.addEdge(2,4,6);
        graph.addEdge(2,3,5);
        graph.addEdge(2,5,4);
        graph.addEdge(3,5,2);
        graph.addEdge(4,5,6);
        Prim prim = new Prim();
        prim.primMST(graph);

    }
}
