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
public class UniquePath {
    public static int uniquePaths(int m, int n) {
        int [][] matrix = new int[m][n];
        for(int i = 0; i < m; i++){
            matrix[i][0] = 1;
        }
        for(int i = 0; i < n; i++){
            matrix[0][i] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                matrix[i][j] = matrix[i-1][j]+matrix[i][j-1];
            }
        }
        return matrix[m-1][n-1];
    }
    
    public static void main(String[] args) {
        uniquePaths(2,2);
    }
}
