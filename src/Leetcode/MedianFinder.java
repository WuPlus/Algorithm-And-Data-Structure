/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

import java.util.ArrayList;

/**
 *
 * @author Wu
 */
public class MedianFinder {
    private ArrayList<Integer> list = new ArrayList();
    // Adds a number into the data structure.
    public void addNum(int num) {
        int low = 0,high = list.size() - 1;
        while(low <= high){
            int mid = high - (high - low)/2;
            if(list.get(mid) == num){
                list.add(mid, num);
                return;
            }else if(list.get(mid) < num){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        list.add(low,num);
    }

    // Returns the median of current data stream
    public double findMedian() {
        int size = list.size();
        if(size % 2 == 0){
            return (list.get(size/2)+list.get(size/2+1))/2.0;
        }else{
            return (double)(list.get(size/2));
        }
    }
    
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(0);        
        mf.addNum(0);
        System.out.println(mf.findMedian());
    }
}
