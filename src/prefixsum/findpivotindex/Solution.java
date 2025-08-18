package prefixsum.findpivotindex;

public class Solution {

  public static void main(String[] args) {
    System.out.println(pivotIndex(new int[]{1,7,3,6,5,6}));
  }

  private static int pivotIndex(int[] nums) {
    int numsArrayLength = nums.length;
    int[] prefixSumArray = new int[numsArrayLength];
    int[] suffixSumArray = new int[numsArrayLength];
    int prefixSum = 0;
    for(int i=0; i<numsArrayLength;i++) {
      prefixSumArray[i] = prefixSum;
      prefixSum = prefixSum + nums[i];
    }
    int suffixSum = 0;
    for(int i=numsArrayLength-1; i>=0;i--) {
      suffixSumArray[i] = suffixSum;
      suffixSum = suffixSum + nums[i];
    }
    for(int i = 0; i<numsArrayLength;i++) {
      if(prefixSumArray[i] == suffixSumArray[i]) {
        return i;
      }
    }
    return -1;
  }
}
