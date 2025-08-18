// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
// Approach:
// Binary search to find peak element by comparing middle element with its neighbors to determine if it's a peak or which direction to search
// If middle element is greater than both neighbors, we've found the peak; otherwise, move towards the side with higher values since peak must exist there
// Handle edge cases where middle element is at boundary (first or last position) by only comparing with the available neighbor

class Solution {
    public int findPeakElement(int[] nums) {
        // Handle single element case
        if (nums.length == 1) {
            return 0;
        }
        
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low)/2;
            
            // Check if current element is a peak
            // For left boundary: only check right neighbor
            // For right boundary: only check left neighbor
            // For middle elements: check both neighbors
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && 
                (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            }
            // If right neighbor is greater, peak must be on the right side
            else if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            }
            // If left neighbor is greater, peak must be on the left side
            else {
                high = mid - 1;
            }
        }
        
        // This should never be reached due to problem constraints
        // but return low as fallback (will be the peak position)
        return low;
    }
}