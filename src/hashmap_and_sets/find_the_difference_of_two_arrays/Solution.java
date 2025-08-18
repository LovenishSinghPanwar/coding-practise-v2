package hashmap_and_sets.find_the_difference_of_two_arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(findTheDifference(new int[]{1, 2, 3}, new int[]{2, 4, 6}));
    }

    private static List<List<Integer>> findTheDifference(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        Set<Integer> nums2Set = new HashSet<>();
        for (int num : nums1) {
            nums1Set.add(num);
        }
        for (int num : nums2) {
            nums2Set.add(num);
        }
        List<Integer> inNum1ButNotIn2 = new ArrayList<>();
        List<Integer> inNum2ButNotIn1 = new ArrayList<>();
        for (int num : nums1Set) {
            if (!nums2Set.contains(num)) {
                inNum1ButNotIn2.add(num);
            }
        }
        for (int num : nums2Set) {
            if (!nums1Set.contains(num)) {
                inNum2ButNotIn1.add(num);
            }
        }
        return List.of(inNum1ButNotIn2, inNum2ButNotIn1);
    }
}
