package stack.decodestring;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }

    private static String decodeString(String input) {
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> integeStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        StringBuilder result = new StringBuilder();
        Integer currentNumber = 0;
        for(int i = 0; i<input.length(); i++) {
            Character character = input.charAt(i);
            if(Character.isDigit(character)) {
                currentNumber = currentNumber * 10 + (character - '0');
            } else if (character == '[') {
                integeStack.push(currentNumber);
                stringStack.push(currentString.toString());
                currentNumber = 0;
                currentString = new StringBuilder();
            } else if (character == ']') {
                StringBuilder tempString = new StringBuilder(stringStack.pop());
                Integer tempNumber = integeStack.pop();
                for(int j =0; j<tempNumber;j++) {
                    tempString.append(currentString);
                }
                currentString = tempString;
            } else {
                currentString.append(character);
            }
        }
        return currentString.toString();
    }
}
