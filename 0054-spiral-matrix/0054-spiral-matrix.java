import java.util.List;
import java.util.Vector;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        Vector<Integer> number = new Vector<>();

        while (top <= bottom && left <= right) {

            // Left to right
            for (int col = left; col <= right; col++) {
                number.add(matrix[top][col]);
            }
            top++;

            // Top to bottom
            for (int row = top; row <= bottom; row++) {
                number.add(matrix[row][right]);
            }
            right--;

            // Right to left
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    number.add(matrix[bottom][col]);
                }
                bottom--;
            }

            // Bottom to top
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    number.add(matrix[row][left]);
                }
                left++;
            }
        }

        return number;
    }
}