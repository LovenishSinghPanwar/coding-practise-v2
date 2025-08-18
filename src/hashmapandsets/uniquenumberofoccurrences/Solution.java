package hashmapandsets.uniquenumberofoccurrences;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        System.out.println(uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
    }

    private static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occrrenceMap = new HashMap<>();
        for (int num : arr) {
            if (occrrenceMap.containsKey(num)) {
                occrrenceMap.put(num, occrrenceMap.get(num) + 1);
            } else {
                occrrenceMap.put(num, 1);
            }
        }
        Map<Integer, Integer> occurrenceCount = new HashMap<>();
        for (Map.Entry<Integer, Integer> mapEntry : occrrenceMap.entrySet()) {
            if (occurrenceCount.containsKey(mapEntry.getValue())) {
                return false;
            }
            occurrenceCount.put(mapEntry.getValue(), 1);
        }
        return true;
    }
}
