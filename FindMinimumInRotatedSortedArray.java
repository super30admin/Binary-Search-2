// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
    - We perform a modified binary search to find the minimum element.
    - If the left half [low..mid] is sorted, then nums[low] is the smallest element in that part.
    - We compare nums[low] with current min and then discard the left half by doing low = mid + 1
    - If the right half [mid..high] is sorted, then nums[mid] is the smallest in that part.
    - We compare nums[mid] with current min and then discard the right half by doing high = mid
    - This ensures we always search in the unsorted (rotated) portion which contains the minimum.
*/

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int min = Integer.MAX_VALUE;

        while (low <= high) {
            // If current segment is already sorted, take the minimum and break early
            if (nums[low] <= nums[high]) {
                min = Math.min(min, nums[low]);
                break;
            }

            int mid = low + (high - low) / 2;

            // Check if the left half is sorted
            if (nums[low] <= nums[mid]) {
                // Update min from the leftmost element
                min = Math.min(min, nums[low]);
                // Discard the left half
                low = mid + 1;
            } else {
                // Right half is sorted
                min = Math.min(min, nums[mid]);
                // Discard the right half
                high = mid - 1;
            }
        }
        return min;
    }
}
