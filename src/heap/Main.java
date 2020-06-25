package heap;

import heap.impl.MaxHeapImpl;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args){
        Integer[] nums = new Integer[]{2,23,30,8,32,31,41,1,15};

        // Heap
        MaxHeapImpl<Integer> maxHeap = new MaxHeapImpl<>();
        // tO(nlogn) (Heapify can make it into O(1))
        for(Integer num : nums){ // O(n)
            maxHeap.offer(num); // tO(logn)
        }
        maxHeap.print();

        // PriorityQueue
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (Integer num : nums){ // O(n)
            priorityQueue.offer(num); // tO(logn)
        }
        System.out.println(priorityQueue.poll());
    }
}
