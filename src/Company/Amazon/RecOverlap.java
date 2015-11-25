/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.Amazon;

/**
 *
 * @author Wu
 */
public class RecOverlap {

    boolean isOverlap(Rec r1, Rec r2) {
        int A = r1.topLeft.x;
        int B = r1.topLeft.y;
        int C = r1.bottomRight.x;
        int D = r1.bottomRight.y;

        int E = r2.topLeft.x;
        int F = r2.topLeft.y;
        int G = r2.bottomRight.x;
        int H = r2.bottomRight.y;
        return !(C <= E || G <= A || D >= F || H >= B);
    }

    private class Rec {

        Pointer topLeft;
        Pointer bottomRight;
    }

    private class Pointer {

        int x;
        int y;
    }
}
