
import java.util.*;

class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();

        backtrack(0, s, current, result);

        return result;
    }

    private void backtrack(int start, String s,
                           List<String> current,
                           List<List<String>> result) {

        // If we reach the end, store the partition
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try every possible substring
        for (int end = start; end < s.length(); end++) {

            String sub = s.substring(start, end + 1);

            // Check if substring is palindrome
            if (isPalindrome(sub)) {

                current.add(sub);

                // Recursively process remaining string
                backtrack(end + 1, s, current, result);

                // Backtracking
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
