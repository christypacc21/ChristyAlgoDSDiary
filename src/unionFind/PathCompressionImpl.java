package unionFind;

public class PathCompressionImpl implements IUnionFind{
    //節點各數
    int count;

    //節點
    private int[] parents;

    //weight
    private int[] rank;

    public PathCompressionImpl(int count) {
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
    // much better performance than find2() | but if in interview, tho find2() is less effective, but easier to remember, so also cna use find2()
    public int find(int index) {
        if (index < 0 || index >= count){
            throw new IllegalArgumentException("越界");
        }
        while (index != parents[index]){
            parents[index] = parents[parents[index]]; // the only dif with UnionByWeightedImpl
            index = parents[index];
        }
        return index;
    }

    public int find2(int index) { //specifically for PathCompressionImpl //a recursion way (more time n space needed in recursion)
        if (index < 0 || index >= count){
            throw new IllegalArgumentException("越界");
        }
        if (index != parents[index]){
            parents[index] = find(parents[index]);
        }
        return parents[index];
    }

    @Override
    public boolean connected(int x, int y) { //(find(p) == find(q))
        return find(x) == find (y);
    }
}
