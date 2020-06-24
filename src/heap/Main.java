package heap;

import heap.impl.MaxHeapImpl;

public class Main {
    public static void main(String[] args){
        MaxHeapImpl<Integer> maxHeap = new MaxHeapImpl<>();
        Integer[] nums = new Integer[]{2,23,30,8,32,31,41,1,15};

        //tO(nlogn) (Heapify can make it into O(1))
        for(Integer num : nums){
            maxHeap.offer(num);
        }
        maxHeap.print();
    }
}
