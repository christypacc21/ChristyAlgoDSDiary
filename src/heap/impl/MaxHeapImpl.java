package heap.impl;

import heap.IMaxHeap;

public class MaxHeapImpl<E extends Comparable<E>> implements IMaxHeap<E>{

    private int capacity;
    private int size;
    private E[] data;

    public MaxHeapImpl(E[] data) {
        this.data = data;
        this.size = data.length;
        this.data = data;
    }

    public MaxHeapImpl() {
        this.capacity = 16;
        this.size = 0;
        this.data = (E[]) new Comparable[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //insert() remove() time : O(logN) per operation
    @Override
    public boolean offer(E e) { // + expandCapacity() //add an item to the end of array //+size, siftup
        if (data.length == size){
            expandCapacity();
        }
        data[size] = e;
        size++;
        siftUp();
        return true;
    }
    public void expandCapacity(){
        E[] temp = (E[]) new Comparable[capacity * 2];
        for (int i = 0; i < capacity; i++){
            temp[i] = data[i];
        }
        capacity *= 2;
        data = temp;
    }

    @Override
    public E poll() { // take away the first item of the array //-size, siftdown
        if (size == 0){
            throw new IllegalArgumentException("heap is empty");
        }
        E item = data[0];
        data[0] = data[size - 1];
        data[size - 1] = null;
        size--;
        siftDown();
        return item;
    }

    @Override
    public E peek() { //peek the root node (array[0])
        if (size == 0){
            throw new IllegalArgumentException("heap is empty");
        }
        return data[0];
    }

    @Override
    public void print() {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }

    }

    private int getParentIndex(int childIndex){
        return (childIndex - 1) / 2; //? why -1
    }
    private int getLeftChildIndex(int parentIndex){
        return 2 * parentIndex + 1;
    }
    private int getRightChildIndex(int parentIndex){
        return 2 * parentIndex + 2;
    }

    private E leftChild(int index){
        return data[getLeftChildIndex(index)];
    }

    private E rightChild(int index){
        return data[getRightChildIndex(index)];
    }

    private E parent(int index){
        return data[getParentIndex(index)];
    }

    private void swap(int i, int j){
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private void siftUp(){ // scene: add new node to the end
        int index = size - 1; // array index starts from 0
        while (getParentIndex(index) >= 0 && parent(index).compareTo(data[index]) < 0){ // if not top node && is smaller than parent node
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void siftDown(){ // scene: delete ndoe (remove top node), now the last node is moved to be as the top node, so index = 0;
        int index = 0;
        while (getLeftChildIndex(index) < size){ // have left child
            // get the biggest value of child node. (to compare with current node. current node smaller, swap, and keep while loop. if not, means current node is at the right position, stop while (finished)).
            int biggerChildIndex = getLeftChildIndex(index);
            if (getRightChildIndex(index) < size && rightChild(index).compareTo(leftChild(index)) > 0){ // have right child and right > left
                biggerChildIndex = getRightChildIndex(index);
            }
            if (data[index].compareTo(data[biggerChildIndex]) > 0){ // if current index > bigger child index, stop, dun needa keep going
                break;
            } else {
                swap(index, biggerChildIndex);
            }
            index = biggerChildIndex;
        }
    }





















}
