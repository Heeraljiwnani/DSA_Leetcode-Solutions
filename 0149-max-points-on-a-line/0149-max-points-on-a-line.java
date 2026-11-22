
import java.util.*;

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;

        if (n <= 2) return n;

        int ans = 0;

        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();

            int duplicates = 0;
            int vertical = 0;
            int horizontal = 0;
            int maxCount = 0;

            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0 && dy == 0) {
                    duplicates++;
                    continue;
                }

                if (dx == 0) {
                    vertical++;
                    maxCount = Math.max(maxCount, vertical);
                    continue;
                }

                if (dy == 0) {
                    horizontal++;
                    maxCount = Math.max(maxCount, horizontal);
                    continue;
                }

                int gcd = gcd(Math.abs(dx), Math.abs(dy));

                dx /= gcd;
                dy /= gcd;

                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                }

                String slope = dy + "/" + dx;

                map.put(slope, map.getOrDefault(slope, 0) + 1);

                maxCount = Math.max(maxCount, map.get(slope));
            }

            ans = Math.max(ans, maxCount + duplicates + 1);
        }

        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
