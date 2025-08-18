package hashmapandsets.determineiftwostringsareclose;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        System.out.println(closeStrings("abc","bca"));
    }

    private static boolean closeStrings(String string1, String string2) {
        int lengthString1 = string1.length();
        int lengthString2 = string2.length();
        if(lengthString2 != lengthString1) {
            return false;
        }
        HashMap<Character, Integer> characterToFreqMapForString1 = new HashMap<>();
        for(int i = 0; i< lengthString1; i++) {
            Character c = string1.charAt(i);
            if(characterToFreqMapForString1.containsKey(c)) {
                characterToFreqMapForString1.put(c, characterToFreqMapForString1.get(c) + 1);
            } else {
                characterToFreqMapForString1.put(c,1);
            }
        }
        HashMap<Character, Integer> characterToFreqMapForString2 = new HashMap<>();
        for(int i = 0; i< lengthString2; i++) {
            Character c = string2.charAt(i);
            if(characterToFreqMapForString2.containsKey(c)) {
                characterToFreqMapForString2.put(c, characterToFreqMapForString2.get(c) + 1);
            } else {
                characterToFreqMapForString2.put(c,1);
            }
        }
        if(!characterToFreqMapForString1.keySet().containsAll(characterToFreqMapForString2.keySet())) {
            return false;
        }
        List<Integer> sortedFreqListOfString1 = characterToFreqMapForString1.values().stream().sorted().collect(Collectors.toList());
        List<Integer> sortedFreqListOfString2 = characterToFreqMapForString2.values().stream().sorted().collect(Collectors.toList());
        if(!sortedFreqListOfString1.equals(sortedFreqListOfString2)) {
            return false;
        }
        return true;
    }
}
