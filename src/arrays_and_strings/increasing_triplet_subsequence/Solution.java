package arrays_and_strings.increasing_triplet_subsequence;

public class Solution {

    public static void main(String[] args) {
        System.out.println(increasingTripletSubsequence(new int[]{20,100,10,12,5,13}));
        System.out.println(increasingTripletSubsequence(new int[]{1,2,3,4,5}));
        System.out.println(increasingTripletSubsequence(new int[]{5,4,3,2,1}));
        System.out.println(increasingTripletSubsequence(new int[]{20,10,5,3,6}));
        System.out.println(increasingTripletSubsequence(new int[]{1,5,0,4,1,3}));
        System.out.println(increasingTripletSubsequence(new int[]{1,2,3}));
    }

//    private static boolean increasingTripletSubsequence(int[] nums) {
//        int numsSize = nums.length;
//        if(numsSize < 3) {
//            return false;
//        }
//        int i=0,j=1,k=2;
//        while (i <= numsSize -3) {
//            if(nums[i] < nums[j] && nums[j] < nums[k]) {
//                return true;
//            }
//            if((i==numsSize-3) && (j==numsSize-2) && (k==numsSize-1)) {
//                break;
//            }
//            if(((k==numsSize-1) && (j!=numsSize-2)) || nums[k] < nums[j]) {
//                j++;
//                k=j+1;
//            } else if((j==numsSize-2 && (i!=numsSize-3)) || nums[j] < nums[i]) {
//                i++;
//                j=i+1;
//                k=j+1;
//            } else if (k!=numsSize-1) {
//                k++;
//            }
//        }
//        return false;
//    }

    private static boolean increasingTripletSubsequence(int[] nums) {
        int firstSmallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int i = 0; i<=nums.length-1;i++) {
            if(nums[i] < firstSmallest) {
                firstSmallest = nums[i];
            } else if (nums[i] < secondSmallest) {
                secondSmallest = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}
