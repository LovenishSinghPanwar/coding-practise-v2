package hashmap_and_sets.equal_row_and_column_pairs;

import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
//        System.out.println(equalPairs(new int[][]{{3,2,1},{1,7,6},{2,7,7}}));
        System.out.println(equalPairs(new int[][]{{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}}));
    }

    private static int equalPairs(int[][] grid) {
        HashMap<String,Integer> rowToFreqMap = new HashMap<>();
        int gridLength = grid.length;
        for(int i = 0; i<gridLength;i++) {
            StringBuilder rowString = new StringBuilder();
            for (int j=0; j<gridLength; j++) {
                rowString.append(grid[i][j]).append("_");
            }
            String finalString = rowString.toString();
            if(rowToFreqMap.containsKey(finalString)) {
                rowToFreqMap.put(finalString, rowToFreqMap.get(finalString) + 1);
            } else {
                rowToFreqMap.put(rowString.toString(), 1);
            }
        }
        int count = 0;
        for(int i = 0; i<gridLength;i++) {
            StringBuilder rowString = new StringBuilder();
            for (int j=0; j<gridLength; j++) {
                rowString.append(grid[j][i]).append("_");
            }
            String finalString = rowString.toString();
            if(rowToFreqMap.containsKey(finalString)) {
                count = count + rowToFreqMap.get(finalString);
            }
        }
        return count;
    }
}
