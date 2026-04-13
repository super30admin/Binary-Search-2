// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach (3 sentences):
We use binary search to find a peak element by checking if the current mid is greater than its neighbors. 
If the right neighbor is greater, it means we are on an increasing slope, so a peak must exist on the right side; otherwise, it lies on the left. 
This works because a peak always exists, and we reduce the search space based on the slope direction.
*/

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid is a peak
            if ((mid == 0 || nums[mid] > nums[mid - 1]) &&
                (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            }

            // Increasing slope → peak on right
            else if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            }

            // Decreasing slope → peak on left
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}