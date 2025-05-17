// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Needed to handle edge cases to avoid out-of-bounds errors
// Implementing from hand working to code implementation issues.

// Your code here along with comments explaining your approach in three sentences only:
// I used binary search to efficiently find a peak element in the array.
// A peak is defined as an element that is greater than its neighbors, and I checked this condition safely by handling boundaries.
// Based on whether the middle element is smaller than its right neighbor, I adjusted the search space accordingly for O(log n) performance.

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length - 1;
        int l = 0, r = n;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if ((mid == 0 || nums[mid] > nums[mid - 1]) 
                && (mid == n || nums[mid] > nums[mid + 1])) {
                return mid;
            } else {
                if (nums[mid] < nums[mid + 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1; // This shouldn't be reached for valid input
    }
}
