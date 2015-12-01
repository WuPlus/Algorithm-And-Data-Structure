/*
 * 一堆平面上的二维点，找离origin最近的K个点
 */
package Company.Amazon.OA2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Wu
 */
public class TopKNearestPointer {

    class Pointer implements Comparable<Pointer> {

        int x;
        int y;

        Pointer(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pointer p) {
            long distance1 = this.x * this.x + this.y * this.y;
            long distance2 = p.x * p.x + p.y * p.y;
            return (distance1 > distance2) ? 1 : -1;
        }
    }
    
    
    /**
     * O(N*logK)
     * @param input
     * @param topK
     * @return 
     */
    static List<Pointer> topKNearestPointer(List<Pointer> input, int topK) {
        PriorityQueue<Pointer> heap = new PriorityQueue(new Comparator<Pointer>() {

            @Override
            public int compare(Pointer o1, Pointer o2) {
                return o2.compareTo(o1);
            }

        });

        for (Pointer p : input) {
            if (heap.size() < topK) {
                heap.add(p);
            } else {
                if (p.compareTo(heap.peek()) == -1) {
                    heap.poll();
                    heap.add(p);
                }
            }
        }

        List<Pointer> res = new LinkedList(heap);
        return res;

    }
   
}
