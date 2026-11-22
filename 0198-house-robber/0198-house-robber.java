
class Solution {
    public int rob(int[] nums) {

        int prev2 = 0;
        int prev1 = 0;

        for (int money : nums) {

            // Maximum money if we rob current house
            int rob = prev2 + money;

            // Maximum money if we skip current house
            int skip = prev1;

            int current = Math.max(rob, skip);

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
