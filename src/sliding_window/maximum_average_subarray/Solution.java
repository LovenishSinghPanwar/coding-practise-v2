package sliding_window.maximum_average_subarray;

public class Solution {

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3},4));
        System.out.println(findMaxAverage(new int[]{-1},1));
    }

//    private static double findMaxAverage(int[] nums, int k) {
//        Double result = null;
//        int numsSize = nums.length;
//        if(numsSize<k) {
//            return 0D;
//        }
//        for(int i = k-1; i<numsSize; i++) {
//            double intermediateAvg = 0D;
//            for(int j=i; j>=i-(k-1); j--) {
//                intermediateAvg = intermediateAvg + nums[j];
//            }
//            if (result==null || result < intermediateAvg) {
//                result = intermediateAvg;
//            }
//        }
//        return result/k;
//    }

    private static double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum / k;
    }
}
