package arrays_and_strings.reverse_vowels_of_a_string;

import java.util.List;

public class Solution {

    public static void main(String[] args) {
        reverseVowelsOfString("IceCreAm");
    }

    private static final List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    private static void reverseVowelsOfString(String s) {

        int leftPointer = 0, rightPointer = s.length() - 1;
        if (leftPointer == rightPointer) {
            System.out.println(s);
            return;
        }
        char[] characterArray = s.toCharArray();

        while (leftPointer < rightPointer) {
            while (leftPointer < rightPointer && !isVowel(characterArray[leftPointer])) {
                leftPointer++;
            }
            while (leftPointer < rightPointer && !isVowel(characterArray[rightPointer])) {
                rightPointer--;
            }
            char temp = characterArray[leftPointer];
            characterArray[leftPointer] = characterArray[rightPointer];
            characterArray[rightPointer] = temp;
            leftPointer++;
            rightPointer--;
        }
        System.out.println(characterArray);

    }

    private static boolean isVowel(char s) {
        return vowels.contains(s);
    }
}
