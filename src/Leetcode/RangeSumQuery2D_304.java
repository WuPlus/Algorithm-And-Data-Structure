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
public class RangeSumQuery2D_304 {

    int[][] sum_matrix;

    public RangeSumQuery2D_304(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return;
        }
        int cols = matrix[0].length;
        sum_matrix = new int[rows + 1][cols + 1];
        int row_sum = 0;
        for (int i = 1; i <= rows; i++) {
            row_sum = sum_matrix[i][0];
            for (int j = 1; j <= cols; j++) {
                sum_matrix[i][j] = row_sum + sum_matrix[i - 1][j] + matrix[i-1][j-1];
                row_sum += matrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = sum_matrix[row2 + 1][col2 + 1] - sum_matrix[row1][col2 + 1] - sum_matrix[row2 + 1][col1] + sum_matrix[row1][col1];
        return sum;
    }
    
    public static void main(String[] args) {
        int [][] matrix = {{8,-4,5},{-1,4,4},{-2,3,1},{-4,4,3}};
        RangeSumQuery2D_304 r = new RangeSumQuery2D_304(matrix);
        r.sumRegion(0,1,0,2);
    }
}
