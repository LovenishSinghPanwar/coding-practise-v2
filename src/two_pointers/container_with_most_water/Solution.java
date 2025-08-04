package two_pointers.container_with_most_water;

public class Solution {

  public static void main(String[] args) {
    int[] height = new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7};
    System.out.println(maxArea(height));
  }

  private static int maxArea(int[] height) {
    int leftPointer = 0;
    int rightPointer = height.length - 1;
    int maxArea = 0;
    while (leftPointer < rightPointer) {
      int length = Math.min(height[leftPointer], height[rightPointer]);
      int width = rightPointer - leftPointer;
      int area = length * width;
      if (maxArea < area) {
        maxArea = area;
        System.out.println(length + " " + width + " " + leftPointer + " " + rightPointer);
      }
      if (height[leftPointer] < height[rightPointer]) {
        leftPointer++;
      } else {
        rightPointer--;
      }
    }
    return maxArea;
  }
}
