package myList.linkedList;

public interface iLinkedList {

    // 佔用大小
    int size();

    // 判斷是否為空
    boolean isEmpty();

    // 按index插入
    void add(int index, int data);

    // 頭部插入
    void addFirst(int data);

    // 尾部插入
    void addLast(int data);


}
