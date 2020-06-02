//package DataStructure;
//
//public class LinkedList {
//
//}

//public class ListNode{
//    int val;
//    ListNode next;
//    ListNode prev; // only for doubly linkedlist
//    ListNode(int x) { val = x;}
//}
//
//public class ListNode{
//    public int data;
//    public ListNode next;
//    public ListNode(int data){
//        this.data = data;
//        this.next = null;
//    }
//}

//------------------------------------1 Insert()---------------------- index > size ---------------------------------------------------

//public void addIndex(int index, int data){
//    if (index < 0 || index > size){
//        throw new IllegalArgumentException("index input error : (<0 or 大於最大已有容量");
//    }
//    ListNode prev = dummy;
//    for (int i = 0; i < index; i++){
//        prev = prev.next;
//    }
//    ListNode node = new ListNode(data);
//    node.next = prev.next;
//    prev.next = node;
//    size++;
//}
//
//public void addFirst(int data){
//    addIndex(0, data);
//}
//
//public void addLast(int data){
//    addIndex(size, data);
//}
//
//public boolean addElement(int data){
//    addIndex(size, data);
//    return true;
//}

//----------------------------------2 Delete()-------------------- index >= size -------------------------------------------------------

//public int removeIndex(int index){ //按index刪除
//    if (index < 0 || index >= size){
//        throw new IllegalArgumentException("index input error : (<0 or 大於最大已有容量");
//    }
//    ListNode prev = dummy;
//    for (int i = 0; i < index; i++){ //Important: 找到current的前一個元素(prev)
//        prev = prev.next;
//    }
//    ListNode delNode = prev.next;
//    prev.next = delNode.next;
//    delNode.next = null;
//    size--;
//    return delNode.data;
//}
//public int removeFirst(){
//    return removeIndex(0);
//}
//public int removeLast(){
//    return removeIndex(size - 1);
//}
//public boolean removeElement(int data){ // 刪除指定元素
//    ListNode prev = dummy;
//    while (prev.next != null) {
//        if (prev.next.data == data){
//            break;
//        }
//        prev = prev.next;
//    }
//    if (prev.next != null){
//        ListNode delNode = prev.next;
//        prev.next = delNode.next;
//        delNode.next = null;
//        size--;
//        return true; // found the node and deleted it successfully.
//    }
//    return false; // cannot find the node, so did not do any deletion.
//}

//----------------------------------3 update()-------------------- index >= size -------------------------------------------------------

//public int get(int index){ //拿到指定元素
//    if (index < 0 || index >= size){
//        throw new IllegalArgumentException("index input error : (<0 or 大於最大已有容量");
//    }
//    ListNode cur = dummy.next;
//    for (int i = 0; i < index; i++){
//        cur = cur.next;
//    }
//    return cur.data;
//}
//
//public int getFirst(){
//    return get(0);
//}
//
//public int getLast(){
//    return get(size - 1);
//}
//
//public void set(int index){
//    if (index < 0 || index >= size){
//        throw new IllegalArgumentException("index input error : (<0 or 大於最大已有容量");
//    }
//    ListNode cur = dummy.next;
//    for (int i = 0; i < index; i++){
//        cur = cur.next;
//    }
//    cur.data = data;
//}

//------------------------------------4 search() (contains() 查找是否包含此元素)----------------------------------------------------------
//public boolean contains(int data){
//    ListNode cur = dummy.next;
//    while (cur != null) {
//        if(cur.data == data) return true;
//        cur = cur.next;
//    }
//    return false;
//}

//--------------------------------- print
//public void print() {
//    ListNode cur = dummy.next;
//    while (cur != null) {
//        System.out.print(cur.data + "->");
//        cur = cur.next;
//    }
//        System.out.println("null");
//}
