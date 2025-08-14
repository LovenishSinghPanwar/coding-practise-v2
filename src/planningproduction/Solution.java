package planningproduction;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {

  public static void main(String[] args) {
    System.out.println(planProduction(List.of(6,5,7), List.of(4,2,1)));   // 9
    System.out.println(planProduction(List.of(5,3), List.of(2,1)));        // 5
    System.out.println(planProduction(List.of(10,8), List.of(5,2)));       // 10
    System.out.println(planProduction(List.of(4,6,5), List.of(2,3,1)));    // 6
    System.out.println(planProduction(List.of(9,8,7), List.of(4,2,3)));    // 12
    System.out.println(planProduction(List.of(6,4,5,3), List.of(3,1,2,1)));// 9
    System.out.println(planProduction(List.of(8,5,6,4), List.of(3,2,2,1)));// 10
    System.out.println(planProduction(List.of(7,6,4,3), List.of(2,2,1,1)));// 8
    System.out.println(planProduction(List.of(10,9,8,7,6), List.of(3,2,2,1,1))); // 15
    System.out.println(planProduction(List.of(5,4,3,6,2), List.of(1,1,1,2,1)));  // 6
    System.out.println(planProduction(List.of(20,15,10), List.of(10,5,4)));      // 20
    System.out.println(planProduction(List.of(7,4,5), List.of(2,1,2)));          // 7
    System.out.println(planProduction(List.of(11,8,6,5), List.of(4,2,2,1)));     // 11
    System.out.println(planProduction(List.of(12,10,9,8,6), List.of(4,3,2,1,1)));// 11
    System.out.println(planProduction(List.of(14,9,6), List.of(5,2,1)));         // 14
    System.out.println(planProduction(List.of(12,9,8,7), List.of(4,3,2,1)));     // 12
    System.out.println(planProduction(List.of(14,12), List.of(5,4)));            // 14
    System.out.println(planProduction(List.of(9,7,6), List.of(3,2,1)));          // 9
    System.out.println(planProduction(List.of(19,15,10,8), List.of(6,4,3,2)));   // 19
    System.out.println(planProduction(List.of(14,12,11,9,7), List.of(5,4,3,2,1))); // 14
  }

  private static int planProduction(List<Integer> worstCase, List<Integer> expected) {
    int maxSize = worstCase.size();
    List<Integer> sortedIndices = IntStream.range(0, maxSize).boxed()
        .sorted(Comparator.comparing(p -> worstCase.get(p) - expected.get(p)))
        .toList();
    List<Integer> worstCaseSorted = sortedIndices.stream().map(worstCase::get).toList();
    List<Integer> expectedSorted = sortedIndices.stream().map(expected::get).toList();

    Integer minCashRequired = worstCaseSorted.getLast();
    Integer result = worstCaseSorted.getLast();
    for(int i = worstCaseSorted.size() - 1; i>=0; i--) {
      if(minCashRequired<worstCaseSorted.get(i)) {
        int diffToAdd = (worstCase.get(i) - minCashRequired);
        minCashRequired = minCashRequired + diffToAdd;
        result = result + diffToAdd;
      }
      minCashRequired = minCashRequired - expectedSorted.get(i);
    }
    return result;
  }
}
