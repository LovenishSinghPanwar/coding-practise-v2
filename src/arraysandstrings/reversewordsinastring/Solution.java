package arraysandstrings.reversewordsinastring;

import java.util.Objects;

public class Solution {

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world  "));
    }

    private static String reverseWords(String s) {
        String[] splitOnSpace = s.split(" ");
        int splitOnSpaceArrayLength = splitOnSpace.length;
        StringBuilder result = new StringBuilder();

        for(int i = splitOnSpaceArrayLength - 1; i>=0;i--) {
            if(Objects.equals(splitOnSpace[i].replace(" ",""), "")) {
                continue;
            }
            if(!(i==splitOnSpaceArrayLength-1)) {
                result.append(" ");
            }
            result.append(splitOnSpace[i]);
        }
        return result.toString();
    }
}
