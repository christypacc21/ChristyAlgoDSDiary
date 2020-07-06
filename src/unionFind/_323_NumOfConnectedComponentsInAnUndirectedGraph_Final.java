package unionFind;

public class _323_NumOfConnectedComponentsInAnUndirectedGraph_Final {

    public int countComponents(int n, int[][] edges){
        int res = n;
        int[] parents = new int[n];
        for (int i = 0; i < parents.length; i++){
            parents[i] = i;
        }

        for (int[] pair : edges){ // if for interview only, this 寫法 already enough, dun reli need those fansy and diverse in UnionFind package.
            int x = find(parents, pair[0]);
            int y = find(parents, pair[1]);
            if (x != y){
                parents[x] = y;
                res--;
            }
        }
        return res;
    }

    private int find (int[] parents, int index){
        while (index != parents[index]){
            parents[index] = parents[parents[index]];
            index = parents[index];
        }
        return index;
    }

    public int find2 (int[] parents, int index){ //recommended to write, in interview, coz easier to understand and more common for those who learn Union Algo
        while (index != parents[index]){
            index = parents[index];
        }
        return index;
    }

}
