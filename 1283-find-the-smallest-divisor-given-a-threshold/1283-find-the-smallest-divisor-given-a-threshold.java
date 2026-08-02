class Solution {
    private int maxElement(int[] nums) {
    int max = nums[0];

    for (int num : nums) {
        if (num > max) {
            max = num;
        }
    }

    return max;
}
    public int smallestDivisor(int[] nums, int threshold) {
    int low = 1;
    int high = maxElement(nums);
        int ans = high;

while (low <= high) {

    int mid = low + (high - low) / 2;

    int sum = 0;

    for (int num : nums) {
        sum += (num + mid - 1) / mid;
    }

    if (sum <= threshold) {
        ans = mid;      // mid works
        high = mid - 1; // try to find a smaller divisor
    } else {
        low = mid + 1;  // need a larger divisor
    }
}

return ans;
    }
}