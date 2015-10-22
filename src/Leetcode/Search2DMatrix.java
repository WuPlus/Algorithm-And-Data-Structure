/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

/**
 *
 * @author Wu
 */
public class Search2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null) return false;
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0,high = n - 1;
        int mid = low;
        while(low < high-1){
            mid = (low+high)/2;
            if(matrix[mid][0] == target) return true;
            else if (matrix[mid][0] > target) high = mid;
            else low = mid;
            System.out.println("low = "+low+" mid ="+mid+" high="+high);
        }
        int row = low;
        System.out.println(row);
        low = 0;high = m -1;
        while(low < high-1){
            mid = (low+high)/2;
            if(matrix[row][mid] == target) return true;
            else if (matrix[row][mid] > target) high = mid;
            else low = mid;
        }
        return false;
    }
    
    public static void main(String[] args) {
        int [][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int [][] matrix2 = {{0},{1}};
        System.out.println(searchMatrix(matrix2,0));
    }
}
