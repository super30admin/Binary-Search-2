// Time Complexity : O(logn) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach:

// Made use of the concept that in a rotated array atleast one part is sorted
// Also made use of the observation that the min element always lies in the unsorted array
// used nums[low] <= nums[mid] to check if the left side of the array is sorted or not
// If it is sorted moved to the right side of the sorted array
// if an array is sorted the arr[low] gives the min element
// Applied binary search to get the answer

class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 0 || nums == null)
            return -1;
        int low = 0, high = nums.length - 1;
        if (nums.length == 1)
            return nums[0];
        if (nums[low] <= nums[high])
            return nums[low];

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[low] <= nums[high])
                return nums[low];
            if ((mid == 0 || nums[mid - 1] > nums[mid]) && (mid == nums.length - 1 || nums[mid + 1] > nums[mid]))
                return nums[mid];
            else if (nums[low] <= nums[mid])
                low = mid + 1;
            else
                high = mid - 1;

        }
        return 9098; // unreachable code
    }
}