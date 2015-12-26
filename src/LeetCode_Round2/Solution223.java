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
public class Solution223 {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left = Math.max(A, E), right = Math.max(Math.min(C, G), left);
        int bottom = Math.max(B, F), top = Math.max(Math.min(D, H), bottom);
        return (C - A) * (D - B) - (right - left) * (top - bottom) + (G - E) * (H - F);
    }
}
