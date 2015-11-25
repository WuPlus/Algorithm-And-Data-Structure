/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.Amazon;

import java.util.Scanner;

/**
 *
 * @author Wu
 */
public class LetterToDigit {
    
    public static void main(String[] args) {
        while (true) {
            Scanner in = new Scanner(System.in);
            String letter = in.nextLine();
            if (letter.length() == 0) {
                System.exit(0);
            }
            if (Character.isLetter(letter.charAt(0))) {
                for (int i = 0; i < letter.length(); i++) {
                    System.out.print(letter.charAt(i) - 'A' + 1 + " ");
                }
                System.out.println();
            } else if (Character.isDigit(letter.charAt(0))) {
                String[] numbers = letter.split(" ");
                for (String number : numbers) {
                    System.out.print((char) (Integer.parseInt(number) + 'A' - 1));
                }
                System.out.println();
            }
        }
    }
}
