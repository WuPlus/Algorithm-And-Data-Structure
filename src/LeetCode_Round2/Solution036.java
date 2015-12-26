/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode_Round2;

/**
 *
 * @author Wu
 */
public class Solution036 {

    public boolean isValidSudoku(char[][] board) {
        boolean[][] set = new boolean[27][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int tmp = board[i][j] - '1';
                    if (set[i][tmp] || set[9 + j][tmp] || set[18 + 3 * (i / 3) + (j / 3)][tmp]) {
                        return false;
                    }
                    set[i][tmp] = true;
                    set[9 + j][tmp] = true;
                    set[18 + 3 * (i / 3) + (j / 3)][tmp] = true;
                }
            }
        }
        return true;
    }
}
