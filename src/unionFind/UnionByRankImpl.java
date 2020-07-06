package unionFind;

public class UnionByRankImpl implements IUnionFind{

    //節點各數
    int count;

    //節點
    private int[] parents;

    //weight
    private int[] rank;

    public UnionByRankImpl(int count) {
        this.count = count;
        parents = new int[count];
        this.rank = new int[count];

        for(int i = 0; i < parents.length; i++) {
            parents[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public void union(int x, int y) { // O(n)
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot){
            return;
        }
        if (rank[xRoot] < rank[yRoot]){
            parents[xRoot] = yRoot;
        } else if (rank[yRoot] < rank[xRoot]){
            parents[yRoot] = xRoot;
        } else {
            parents[yRoot] = xRoot;
            rank[xRoot]++;
        }
    }

    @Override
    public int find(int index) { //O(1)
        if (index < 0 || index >= count){
            throw new IllegalArgumentException("越界");
        }
        while (index != parents[index]){
            index = parents[index];
        }
        return index;
    }

    @Override
    public boolean connected(int x, int y) { //(find(p) == find(q))
        return find(x) == find (y);
    }
}
