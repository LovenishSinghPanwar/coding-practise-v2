package stack.removingstarsfromastring;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        System.out.println(removeStarts("leet**cod*e"));
    }

    private static String removeStarts(String s) {
        Stack<Character> characterStack = new Stack<>();
        for(Character c: s.toCharArray()) {
            if(c == '*') {
                characterStack.pop();
            } else {
                characterStack.push(c);
            }
        }
        StringBuilder finalString = new StringBuilder();
        for(Character c: characterStack) {
            finalString.append(c);
        }
        return finalString.toString();
    }
}
