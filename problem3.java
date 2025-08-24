// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only

/**
 * we perform binary search and compare the pivot element with its left and right neighbors to find the peak
 * if the pivot element was not bigger than its immediate neighbors, then we move to the number on the bigger side since we will eventually hit the peak because the boundary outside of the array is minus infinity
 */
class Solution {
    public int findPeakElement(int[] nums) {

        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            // if number is greather than both neighbors or we reached the end of the array on either side
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == n - 1 || nums[mid] > nums[mid + 1]))
                return mid;
                // since we have to find the peak, we have to move to the side where bigger number than current number exists
            else if (nums[mid] < nums[mid + 1])
                low = mid + 1;
            else
                high = mid - 1;
        }

        // unreachable
        return -1;
    }
}