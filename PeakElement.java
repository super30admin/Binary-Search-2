// Time Complexity : O(logn) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach:

// Made use of the concept that there is atleast one peak in an array
// Also made use of the observation that the chance of finding a peak to the larger side is greater
// Applied binary search to get the answer

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1]))
                return mid;
            else if (nums[mid + 1] > nums[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1; // unreachable code
    }
}