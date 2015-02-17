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
public class Atoi {
    public static void main(String[] args) {
        System.out.println(atoi("1"));
        Character.isWhitespace(' ');
        int x = 3;
    }
    
    public static int atoi(String str) {
        boolean b = false;
        if(str.equals("")){
            return 0;
        }
        while(str.charAt(0) == ' '){
            str = str.substring(1);
        }
        if(str.charAt(0) == '-'){
            b = true;
            str = str.substring(1);
        }
        int length = str.length();
        int ret = 0;
        int c;
        for(int i = 0;i<length;i++){
            c = (int)str.charAt(i);
            if(c < 48 || c > 57)
                break;
            System.out.println("ret = "+ ret);
            ret = ret*10 + Integer.parseInt(str.charAt(i)+"");
        }
        if(b){
            ret = -ret;
        }
        return ret;
    }
}
