package com.kk.string;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedBrackets {
    //Input: exp = “[()]{}{[()()]()}”
    //Output: Balanced
    //
    //Input: exp = “[(])”
    public static void main(String[] args) {
        String input = "[()]{}{[()()]()}";
        System.out.println(isBalanced(input) ? "Balanced" : "Not Balanced");
    }

    private static boolean isBalanced(String value) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if ('[' == c || '(' == c || '{' == c) {
                stack.push(c);
                continue;
            }
            // If current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
            if (stack.isEmpty()) return false;

            char pop = stack.pop();
            switch (c) {
                case ')':
                    if ('{' == pop || '[' == pop) return false;

                    break;
                case '}':
                    if ('(' == pop || '[' == pop) return false;
                    break;

                case ']':
                    if ('{' == pop || '(' == pop) return false;
                    break;
                default:
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
