/*
 * 给一个2D matrix，bool 型，初始状态是都是false,
 * 要求写一个flip函数，实现把其中一个element由false变成true。 
 * 要求是所有false element被翻转的概率相等。
 */
package Company.Google;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Wu
 */
public class RandomFlip {
    class Pair {
        int i,j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    
    boolean [][] m;
    ArrayList<Pair> al = new ArrayList();
    
    public RandomFlip(boolean [][] matrix){
        this.m = matrix;
        if(matrix == null || matrix[0].length == 0)
            return;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                al.add(new Pair(i,j));
            }
        }
    }
    
    public void flip(){
        int rand = (int)(Math.random()*al.size());
        int i = al.get(rand).i;
        int j = al.get(rand).j;
        m[i][j] = true;
        al.remove(rand);
    }
    
    public static void main(String[] args) {
        boolean [][] m = {{false,false,false},{false,false,false},{false,false,false}};
        RandomFlip rf = new RandomFlip(m);
        rf.flip();
        for (int i = 0; i < m.length; i++) {
            System.out.println(Arrays.toString(m[i]));
        }
        rf.flip();
        for (int i = 0; i < m.length; i++) {
            System.out.println(Arrays.toString(m[i]));
        }
        rf.flip();
        for (int i = 0; i < m.length; i++) {
            System.out.println(Arrays.toString(m[i]));
        }
    }
}
