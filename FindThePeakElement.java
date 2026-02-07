# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : if the array is raising the peak must be ahead and if the arrray is falling the peak from be behind . This lets us discard the half of the array each step using binary search


  class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(mid == low || nums[mid] > nums[mid - 1] && (mid == high || nums[mid] > nums[mid + 1])){
                return mid;
            }else if(nums[mid + 1] > nums[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }

        }
        
        return low;
    }
}
