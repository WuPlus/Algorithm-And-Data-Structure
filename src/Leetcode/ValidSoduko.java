/*
 Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

 The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

 */
package Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Wu
 */
public class ValidSoduko {

    public boolean isValidSudoku(char[][] board) {
        Set<Character> rowset = new HashSet<Character>();
        Set<Character> colset = new HashSet<Character>();
        int l = board.length;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (board[i][j] != '.' && !rowset.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !colset.add(board[j][i])) {
                    return false;
                }
            }
            rowset.clear();
            colset.clear();
        }

        for (int i = 0; i < l; i = i + 3) {
            for (int j = 0; j < l; j = j + 3) {
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        if (board[i + m][j + n] != '.' && !rowset.add(board[i + m][j + n])) {
                            return false;
                        }
                    }
                }
                rowset.clear();
            }
        }
        return true;
    }
}
