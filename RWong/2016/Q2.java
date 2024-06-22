/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2016;
import java.util.Scanner;
import java.util.Stack;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Q2 {
    public static void main(String[] args) {
        String sentence = "";
        try {
            Scanner sc = new Scanner(new FileInputStream("BracMatch.txt"));
            while (sc.hasNextLine()) {
                sentence += sc.nextLine();
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (isMatch(sentence))
            System.out.println("YES - all matched!");
        else
            System.out.println("Not all bracket are matched.");
    }

    private static boolean isMatch(String sentence) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < sentence.length(); i++) {
            char term = sentence.charAt(i);
            if (isLeft(term)) {
                stack.push(term);
            } else if (isRight(term)) {
                char left = stack.pop();
                if (!isPair(left, term)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isLeft(char c) {
        return c == '[' || c == '{' || c == '(' || c == '<';
    }

    private static boolean isRight(char c) {
        return c == ']' || c == '}' || c == ')' || c == '>';
    }

    private static boolean isPair(char c1, char c2) {
        return (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}')
                || (c1 == '(' && c2 == ')' || (c1 == '<' && c2 == '>'));
    }
}
