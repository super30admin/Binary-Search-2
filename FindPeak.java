// Time Complexity : O(log(N))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while(low < high) {
            mid = low + (high-low)/2;
            if(nums[mid] < nums[mid+1]) {
                low = mid+1;
            }
            else {
                high = mid;
            }
        }
        return low;
    }
}