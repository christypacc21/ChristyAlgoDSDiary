//package myList.linkedList.imp;
//
//import myList.linkedList.iLinkedList;
//import myList.linkedList.ListNode;
//
//public class LinkedListImpl implements iLinkedList{
//
//    private int size;
//
//    private ListNode dummy;
//
//    public LinkedListImpl() {
//        this.dummy = new ListNode(0);
//        this.size = 0;
//    }
//
//    @Override
//    public int size() {
//        return size;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return size == 0;
//    }
//
//    @Override
//    public void add(int index, int data) {
//        if (index < 0 || index > size) {
//            throw new IllegalArgumentException("index input fault (<= 0  or > 最大已有容量)");
//        }
//        ListNode prev = dummy;
//        for (int i = 0; i < index; i++) {
//            prev = prev.next;
//        }
//
//        ListNode node = new ListNode(data);
//        node.next = prev.next;
//        prev.next = node;
//        size++;
//    }
//
//    @Override
//    public void addFirst(int data) {
//        add(0, data);
//    }
//
//    @Override
//    public void addLast(int data) {
//        add(size, data);
//    }
//}
