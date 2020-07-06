package unionFind;

public class QuickFindImpl implements IUnionFind{

    //節點各數
    int count;

    //節點
    private int[] id;

    public QuickFindImpl(int count) {
        this.count = count;
        id = new int[count];

        for(int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public void union(int x, int y) { // O(n)
        int A = find(x);
        int B = find(y);
        if (A == B){
            return;
        }
        for (int i = 0; i < id.length; i++){
            if (id[i] == A){
                id[i] = B;
            }
        }
    }

    @Override
    public int find(int index) { //O(1)
        if (index < 0 || index >= count){
            throw new IllegalArgumentException("越界");
        }
        return id[index];
    }

    @Override
    public boolean connected(int x, int y) { //(find(p) == find(q))
        return find(x) == find (y);
    }
}
