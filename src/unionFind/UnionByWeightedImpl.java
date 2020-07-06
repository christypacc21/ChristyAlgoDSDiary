package unionFind;

public class UnionByWeightedImpl implements IUnionFind{

    //節點各數
    int count;

    //節點
    private int[] parents;

    //weight
    private int[] size;

    public UnionByWeightedImpl(int count) {
        this.count = count;
        parents = new int[count];
        this.size = new int[count];

        for(int i = 0; i < parents.length; i++) {
            parents[i] = i;
            size[i] = 1;
        }
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot){
            return;
        }
        if (size[xRoot] < size[yRoot]){
            parents[xRoot] = yRoot;
            size[yRoot] += size[xRoot];
        } else {
            parents[yRoot] = xRoot;
            size[xRoot] += size[yRoot];
        }
    }

    @Override
    public int find(int index) {
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
