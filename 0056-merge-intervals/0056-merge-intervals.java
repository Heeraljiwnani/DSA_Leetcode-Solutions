
import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        // Sort intervals by starting point
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        for (int[] interval : intervals) {

            // Add interval if result is empty or no overlap exists
            if (result.isEmpty() ||
                result.get(result.size() - 1)[1] < interval[0]) {

                result.add(interval);

            } else {
                // Merge overlapping intervals
                result.get(result.size() - 1)[1] =
                    Math.max(result.get(result.size() - 1)[1], interval[1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
