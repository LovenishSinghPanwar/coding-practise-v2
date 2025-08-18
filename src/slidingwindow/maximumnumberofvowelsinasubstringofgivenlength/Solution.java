package slidingwindow.maximumnumberofvowelsinasubstringofgivenlength;

import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {
        System.out.println(maxVowels("leetcode",2));
        System.out.println(maxVowels("ibpbhixfiouhdljnjfflpapptrxgcomvnb",33));
    }

    private static HashSet<Character> vowels = new HashSet<>();
    static {
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
    }


    private static int maxVowels(String s, int k) {
        if(s.length() < k) {
            return 0;
        }
        int currVowelCount = 0;
        int maxVowelCount = 0;
        for(int i = 0; i<k; i++) {
            if(vowels.contains(s.charAt(i)) ) {
                currVowelCount++;
                maxVowelCount++;
            }
        }
        if(currVowelCount == k) {
            return currVowelCount;
        }
        for(int i=k;i<s.length();i++) {
            if(vowels.contains(s.charAt(i-k))) {
                currVowelCount--;
            }
            if(vowels.contains(s.charAt(i))) {
                currVowelCount++;
            }
            if(currVowelCount==k) {
                return currVowelCount;
            }
            if(maxVowelCount < currVowelCount) {
                maxVowelCount = currVowelCount;
            }
        }
        return maxVowelCount;
    }
}
