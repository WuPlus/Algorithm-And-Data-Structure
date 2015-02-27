/*
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
package Leetcode;

/**
 *
 * @author Wu
 */
public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        int index = 0;
        int tail = A.length - 1;
        while(index <= tail){
            if(A[index] == elem){
                A[index] = A[tail];
                tail--;
            }
            else{
                index++;
            }
        }
        return index;
    }
}
