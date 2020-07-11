package graph;

import java.util.*;

//word-> use hashmap find the word's index-> then in ArrayList find the corresponding Node
// step1 construct graph step2 BFS

// ? a question from a student : 那为啥graph不直接存map of node呢？{word，node} ?

public class _127_wordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        //Construct Graph
        Graph graph = new Graph();
        for (String word : wordList){
            graph.addNode(new Node(word));
        }
        if (!wordList.contains(beginWord)){
            graph.addNode(new Node(beginWord));
            wordList.add(beginWord);
        }

        for(String word : wordList){
            Node node = graph.getNode(word); //word-> use hashmap find the word's index-> then in ArrayList find the corresponding Node
            for (int i = 0; i < word.length(); i++){
                char[] wordUnit = word.toCharArray();
                for (char j = 'a'; j <= 'z'; j++){ //?!
                    wordUnit[i] = j;
                    String temp = new String(wordUnit);
                    if (graph.getNode(temp) != null && !node.neighbors.contains(temp) && !temp.equals(word)){
                        node.neighbors.add(graph.getNode(temp));
                    }
                }
            }
        }

        //BFS
        HashSet<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        visited.add(graph.getNode(beginWord));
        queue.offer(graph.getNode(beginWord));

        int res = 0;

        while (!queue.isEmpty()){
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++){
                Node node = queue.poll();
                if (node.word.equals(endWord)){
                    return res;
                }
                for (Node neighbor : node.neighbors){
                    if (!visited.contains(neighbor)){
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }
        return -1;
    }

    class Graph{
        List<Node> nodes;
        HashMap<String, Integer> map; // String word : nodes.size()

        public Graph(){
            this.nodes = new ArrayList<>();
            this.map = new HashMap<>();
        }

        public void addNode(Node node){
            map.put(node.word, nodes.size());
            nodes.add(node);
        }

        public Node getNode(String word){
            if (map.containsKey(word)){
                return nodes.get(map.get(word));
            }
            return null;
        }

    }

    class Node {
        String word;
        List<Node> neighbors;

        public Node(String word) {
            this.word = word;
            this.neighbors = new ArrayList<>();
        }
    }
}


