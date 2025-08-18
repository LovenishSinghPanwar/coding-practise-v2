package twopointers.issubsequence;

public class Solution {

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc","ahbgdc"));
        System.out.println(isSubsequence("axc","ahbgdc"));
    }

    private static boolean isSubsequence(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if(sLength == 0) {
            return true;
        }
        if(tLength == 0) {
            return false;
        }
        int pointerForTString=0;
        int pointerForSString=0;
        while(pointerForTString < tLength) {
            if(s.charAt(pointerForSString) == t.charAt(pointerForTString)) {
                pointerForSString++;
            }
            if(pointerForSString == sLength) {
                return true;
            }
            pointerForTString++;
        }
        return false;
    }
}
