// Time complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to revise basic syntax

class Solution {
    public int findPeakElement(int[] nums) {
        // Base Case
        if (nums == null || nums.length == 0){
            return -1;
        }

        int low = 0, n = nums.length;
        int high = n - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2; // To prevent Integer Overflow

            // Check if mid is a peak
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == n - 1 || nums[mid] > nums[mid + 1])){
                return mid;
            }
            else if (nums[mid + 1] > nums[mid]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}