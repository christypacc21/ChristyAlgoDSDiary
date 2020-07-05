package heap;

import heap.impl.MaxHeapImpl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void PriorityQueueCompare3(){ // 重寫 PriorityQueue compare(types other than Integer, eg a Node)
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2){
                return o1.a - o2.a;
            }
        });

        //another xiefa of compare, but rarely use.
        String[] strings = new String[] {"12", "23"};
        Arrays.sort(strings, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                String s1 = o1 + o2;
                String s2 = o1;
                return s1.compareTo(s2);
            }
        });
    }

    public static void PQCompare4(){ //lambda expression
        int[] nums = new int[]{1,2,3,4};
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((a, b) -> (a.a - b.a)); //lambda expression
        PriorityQueue<int[]> priorityQueue1 = new PriorityQueue<>((a, b) -> (a[0] + a[1] - b[0] - b[1])); //lambda expression 變形
    }

    class Node{
        int a;
        int b;
    }


    public static void main(String[] args){
        // Heap -----------------------------------------------------------------
        MaxHeapImpl<Integer> maxHeap = new MaxHeapImpl<>();
        Integer[] nums = new Integer[]{2,23,30,8,32,31,41,1,15};
        // tO(nlogn) (Heapify can make it into O(1))
        for(Integer num : nums){ // O(n)
            maxHeap.offer(num); // tO(logn)
        }
        maxHeap.print();
        System.out.println(" ");
        System.out.println("-----");

        // PriorityQueue compare 1 ----------------------------------------------------------------- 正常PriorityQueue compare的形式
        Integer[] nums2 = new Integer[]{2,23,30,8,32,31,41,1,15};
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (Integer num : nums2){ // O(n)
            priorityQueue.offer(num); // tO(logn)
        }
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println("-----");

        // PriorityQueue compare 2 -----------------------------------------------------------------重寫 PriorityQueue compare(Integer) - more common to use coz many time the default comparator not arm 心水
        Integer[] nums3 = new Integer[]{2,23,30,8,32,31,41,1,15};
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o2 - o1; // descending. If want asc, return o1 - o2;
            }
        });

        for (Integer num : nums3){ // O(n)
            priorityQueue2.offer(num); // tO(logn)
        }
        System.out.println(priorityQueue2.poll());
        System.out.println(priorityQueue2.poll());
    }
}
