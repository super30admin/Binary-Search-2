// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only

/**
 * we find the minimum via doing binary search on the array and discarding the sorted side since the minimum element can't exist in the sorted side
 */
class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];

        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            // if we found the low on unsorted side, we found the match
            if (nums[low] < nums[high]) return nums[low];
            // if number is smaller than its both neighbors, we found the match
            if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == n - 1 || nums[mid] < nums[mid + 1]))
                return nums[mid];
                // left is sorted so ignoring the left side since number can't exist here
            else if (nums[low] <= nums[mid])
                low = mid + 1;
                // rihgt is sorted so ignoring the right side since number can't exist here
            else
                high = mid - 1;
        }

        // unreachable
        return -1;
    }
}