/*
 * 背景是比尔盖茨分糖果， 其实问题是一个数组， 
 * 找出其中k个元素的子集使得k个数中最大值和最小值差值最小， 返回这个差值
 */
package Company.Alarm;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @author Wu
 */
public class KElementMaxGap {
    
    /**
     * Find the max gap in K continues element in the input array 
     * Time Complexity: N
     * @param input
     * @param k
     * @return max gap
     */
    public int KElementMaxGap(int[] input, int k) {
        int result = 0;
        int length = input.length;
        Deque<Integer> maxQueue = new LinkedList();
        Deque<Integer> minQueue = new LinkedList();
        
        for(int i = 0; i < length; i++){
            while(!maxQueue.isEmpty() && maxQueue.peek() < i - k + 1){
                maxQueue.poll();
            }
            while(!minQueue.isEmpty() && minQueue.peek() < i - k + 1){
                minQueue.poll();
            }
            
            while(!maxQueue.isEmpty() && input[maxQueue.peekLast()] < input[i]){
                maxQueue.pollLast();
            }
            
            while(!minQueue.isEmpty() && input[minQueue.peekLast()] > input[i]){
                minQueue.pollLast();
            }
            maxQueue.add(i);
            minQueue.add(i);
            
            result = Math.max(result, input[maxQueue.peek()] - input[minQueue.peek()]);
        }
        
        return result;
    }
    
    /**
     * For test only
     * @param args 
     */
    public static void main(String[] args) {
        KElementMaxGap k = new KElementMaxGap();
        int [] input = {1,3,-1,-3,5,3,6,7};
        int r = k.KElementMaxGap(input, 4);
        System.out.println(r);
    }
}
