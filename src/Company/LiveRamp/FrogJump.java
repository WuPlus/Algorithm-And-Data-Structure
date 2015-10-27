/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.LiveRamp;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Wu
 */
public class FrogJump {

    /**
     * Solution for frog Jump
     *
     * @param A
     * @param X Distance
     * @param D The max step that frog can jump
     * @return
     */
    public static int solution(int[] A, int X, int D) {
        int totalTime = A.length;
        Map<Integer, Integer> route = new HashMap();
        for (int i = 1; i <= D; i++) {
            route.put(i, 1);
        }
        for (int i = 0; i < totalTime; i++) {
            //color the route
            for (int j = 1; j <= D; j++) {
                int temp = A[i] + j;
                if (temp <= X) {
                    route.put(temp, 1);
                }
            }
            //check if all route has been colored
            if (route.size() == X) {
                return i;
            }
        }
        return -1;
    }

    /**
     * For test
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] time = {4, 5, 2, 8, 3};
        System.out.println(solution(time, 7, 3));
    }

}
