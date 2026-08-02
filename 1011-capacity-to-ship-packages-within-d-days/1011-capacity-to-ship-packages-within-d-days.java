class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int left = 0;
        int right = 0;

        // Find the minimum and maximum possible capacities
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (canShip(weights, days, mid)) {
                // mid capacity works, so try a smaller capacity
                right = mid - 1;
            } else {
                // mid capacity does not work, so increase capacity
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canShip(int[] weights, int days, int capacity) {

        int requiredDays = 1;
        int currentWeight = 0;

        for (int weight : weights) {

            // If adding this package exceeds capacity,
            // start loading it on the next day
            if (currentWeight + weight > capacity) {
                requiredDays++;
                currentWeight = 0;
            }

            currentWeight += weight;
        }

        return requiredDays <= days;
    }
}