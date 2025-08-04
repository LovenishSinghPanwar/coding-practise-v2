package two_pointers.max_number_of_k_sum_pairs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{1, 2, 3, 4}, 5));
    }

    private static int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> trackingMap = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            int secondPartOfSum = k - num;
            if (trackingMap.getOrDefault(secondPartOfSum, 0) > 0) {
                trackingMap.put(secondPartOfSum, trackingMap.getOrDefault(secondPartOfSum, 0) - 1);
                count++;
            } else {
                trackingMap.put(num, trackingMap.getOrDefault(num, 0) + 1);
            }
        }
        return count;
    }
}
