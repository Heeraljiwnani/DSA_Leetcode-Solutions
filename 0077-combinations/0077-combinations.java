
import java.util.*;

class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k, new ArrayList<>());
        return result;
    }

    public void backtrack(int start, int n, int k, List<Integer> temp) {

        // Base case: combination of size k is formed
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // Try all possible numbers
        for (int i = start; i <= n; i++) {

            temp.add(i);

            backtrack(i + 1, n, k, temp);

            // Backtracking: remove the last added element
            temp.remove(temp.size() - 1);
        }
    }
}
