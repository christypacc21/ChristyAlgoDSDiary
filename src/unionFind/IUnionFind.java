package unionFind;

public interface IUnionFind {
    //有多少個節點
    int count();

    //兩個節點進行融合
    void union(int x, int y);

    //找到對應的集合 (this node belongs to which set)
    int find(int index);

    //判斷兩個點是否屬於同一個集合
    boolean connected(int x, int y);
}
