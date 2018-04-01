package datastructures.heap;

import java.util.*;

public class RunningMedian {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        double median = 0;
        for(int i=0;i<a.length;i++){
            if(a[i]>=median){
                minHeap.add(a[i]);
                balance(minHeap, maxHeap);
                median = calculateMedian(minHeap, maxHeap);
            } else if(a[i]<median){
                maxHeap.add(a[i]);
                balance(minHeap, maxHeap);
                median = calculateMedian(minHeap, maxHeap);
            }
            System.out.println(median);
        }
    }

    private static void balance(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap){
        if(Math.abs(minHeap.size()-maxHeap.size())>1){
            if(minHeap.size()>maxHeap.size())
                maxHeap.add(minHeap.poll());
            else
                minHeap.add(maxHeap.poll());
        }
    }

    private static double  calculateMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap){
        if(minHeap.size()==maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        else
        if(minHeap.size()>maxHeap.size())
            return minHeap.peek();
        else
            return maxHeap.peek();
    }

}
