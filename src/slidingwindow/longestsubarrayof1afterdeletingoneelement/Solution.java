package slidingwindow.longestsubarrayof1afterdeletingoneelement;

public class Solution {

  public static void main(String[] args) {
    System.out.println(longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
    System.out.println(longestSubarray(new int[]{1,1,0,1}));
    System.out.println(longestSubarray(new int[]{1,1,1}));
  }

  private static int longestSubarray(int[] nums) {
    boolean itemDeleted = false;
    int leftPointer = 0;
    int rightPointer = 0;
    int max = 0;
    while (rightPointer< nums.length) {
      if(nums[rightPointer] == 1) {
        rightPointer++;
      } else if(!itemDeleted) {
        itemDeleted = true;
        rightPointer++;
      } else {
        while (itemDeleted) {
          if(nums[leftPointer]!=1) {
            itemDeleted=false;
          }
          leftPointer++;
        }
        itemDeleted=true;
        rightPointer++;
      }
      max = Math.max(max, (rightPointer - leftPointer - 1));
    }
    return max;
  }
}
