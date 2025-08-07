package prefix_sum.find_the_highest_altitude;

public class Solution {

  public static void main(String[] args) {
    System.out.println(largestAltitude(new int[] {-5, 1, 5, 0, -7}));
  }

  private static int largestAltitude(int[] gain) {
    int startingAltitude = 0;
    int max = 0;
    for (int altitude : gain) {
      startingAltitude = startingAltitude + altitude;
      max = Math.max(startingAltitude, max);
    }
    return max;
  }
}
