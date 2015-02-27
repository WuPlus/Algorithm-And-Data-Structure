/*
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 */
package Leetcode;

/**
 *
 * @author Wu
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] A) {
        int length = A.length;
        if(length == 0) return 0;
        int newIndex = 0;
        int current = A[0];
        int index = 1;
        while(index < length){
            if(A[index] == current){
                index++;
            }else{
                newIndex++;
                current = A[index];
                A[newIndex] = current;
                index++;
            }
        }
        return newIndex+1;
    }
}
