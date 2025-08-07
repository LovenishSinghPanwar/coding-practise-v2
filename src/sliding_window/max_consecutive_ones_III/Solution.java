package sliding_window.max_consecutive_ones_III;

public class Solution {

  public static void main(String[] args) {
    System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0},2));
    System.out.println(longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1},3));
    System.out.println(longestOnes(new int[]{0,0,0,0,0,0},1));
  }

  private static int longestOnes(int[] nums, int k) {
    int leftPointer = 0;
    int rightPointer = 0;
    int max = Integer.MIN_VALUE;
    int numberOfZeroesInWindow = 0;
    while(rightPointer < nums.length) {
      if(nums[rightPointer] == 0) {
        numberOfZeroesInWindow++;
      }
      if(numberOfZeroesInWindow > k) {
        if (nums[leftPointer] == 0) {
          numberOfZeroesInWindow--;
        }
        leftPointer++;
      }
        rightPointer++;
      max = Math.max(max, (rightPointer-leftPointer));
    }
    return max;
  }

//  private static int longestOnes(int[] nums, int k) {
//    int max = 0;
//    int copyOfK = k;
//    int tempMax = 0;
//    for (int i = 0; i < nums.length; i++) {
//      if(nums[i] == 0) {
//        tempMax++;
//        copyOfK--;
//      } else if (nums[i] == 1) {
//        tempMax++;
//      }
//      if(copyOfK == 0) {
//        max = Math.max(tempMax, max);
//        copyOfK = k;
//        tempMax = 0;
//      }
//    }
//    return max;
//  }
}
