class Solution {
    public int findPeakElement(int[] nums) {
        int size = nums.length;
        int maxElement = 0;
        for(int i = 0;i<size;i++){
            if(size == 1){
                return 0;
            }
            if(i==0){
                if(nums[i]>nums[i+1]){
                    maxElement = i;
                }
            }
            else if(i == size-1){
                if(nums[i]>nums[i-1]){
                    maxElement = i;
                }
            }
            else{
                if(nums[i]>nums[i-1] && nums[i]>nums[i+1]){
                    maxElement = i;
                }
            }
            
        }
        return maxElement;
    }
}